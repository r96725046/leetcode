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
        Deque<Integer> q=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            while(!q.isEmpty()&&nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(q.peek()<=i-k)
                q.poll();
            if(i+1>=k)
                res[i-k+1]=nums[q.peek()];
        }
        return res;
    }
}
// @lc code=end

