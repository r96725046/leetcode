/*
 * @lc app=leetcode id=1696 lang=java
 *
 * [1696] Jump Game VI
 */

// @lc code=start
class Solution {
    public int maxResult(int[] nums, int k) {
        int[] res=new int[nums.length];

        Deque<Integer> q=new LinkedList<>();
        q.offer(0);
        res[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            res[i]=res[q.peekFirst()]+nums[i];
            while(!q.isEmpty()&&res[q.peekLast()]<=res[i])
                q.pollLast();
            q.offer(i);
            if(q.peekFirst()<=i-k)
                q.poll();
        }
        return res[nums.length-1];
    }
}
// @lc code=end

