/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    // ****
    // 1.nums[q.peekLast()] and q.pollLast()
    // 2.put i to queue
    // 3.poll if peek<i-k
    // 4.i+1>=k set res
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        int index=0;
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(deque.peekFirst()<=i-k)
                deque.pollFirst();
            if(i>=k-1){
                res[index++]=nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
// @lc code=end

