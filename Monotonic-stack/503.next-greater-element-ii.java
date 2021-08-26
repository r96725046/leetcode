/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[nums.length];

        for(int i=0;i<2*nums.length-1;i++){

            if(i<nums.length)
                res[i]=-1;
            int idx=i%nums.length;
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[idx])
            {
                int j=stack.pop();
                res[j]=nums[idx];
            }

            if(i<nums.length)
                stack.push(i);
        }
        return res;
    }
}
// @lc code=end

