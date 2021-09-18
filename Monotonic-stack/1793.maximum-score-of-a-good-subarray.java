/*
 * @lc app=leetcode id=1793 lang=java
 *
 * [1793] Maximum Score of a Good Subarray
 */

// @lc code=start
class Solution {
    public int maximumScore(int[] nums, int k) {
        Stack<Integer> stack=new Stack<>();
        int res=0;
        stack.push(-1);
        
        for(int i=0;i<nums.length;i++){
            while(stack.peek()!=-1&&nums[stack.peek()]>=nums[i]){
                int pre=stack.pop();
                if(stack.peek()<k&&i>k){
                    res=Math.max(res,nums[pre]*(i-1-stack.peek()));
                }
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int pre=stack.pop();
            if(stack.peek()<k)
            {
                res=Math.max(res,nums[pre]*(nums.length-1-stack.peek()));
            }
        }
        return res; 
        
    }
}
// @lc code=end

