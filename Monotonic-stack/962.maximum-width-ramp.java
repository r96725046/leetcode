/*
 * @lc app=leetcode id=962 lang=java
 *
 * [962] Maximum Width Ramp
 */

// @lc code=start
class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(stack.isEmpty()||nums[stack.peek()]>=nums[i])
                stack.push(i);
        }
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty()&&nums[i]>=nums[stack.peek()]){
                max=Math.max(max,i-stack.pop());
            }
        }
        return max;
    }
}
// @lc code=end

