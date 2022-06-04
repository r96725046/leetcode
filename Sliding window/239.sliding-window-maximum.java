/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    // ****
    // 1.remove index <= i-k from queue head
    // 2.remove item < cur from queue end
    // 3.put i to queue
    // 4.if i>=k-1, 
    //   put nums[queue.peek()] to an int array or alist 
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d=new LinkedList<>();
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){

            while(d.size()>0&&d.peekFirst()<=i-k){
                d.pollFirst();
            }
            while(d.size()>0){
                int j=d.peekLast();
                if(nums[i]>nums[j]){
                    d.pollLast();
                }else
                    break;
            }
            d.offerLast(i);
            if(i>=k-1)
                list.add(nums[d.peekFirst()]);
        }
        int[] res=new int[list.size()];
        for(int i=0;i<list.size();i++)
            res[i]=list.get(i);
        return res;
    }
}
// @lc code=end

