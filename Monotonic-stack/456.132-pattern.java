/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 */

// @lc code=start
class Solution {
    // 
    //https://leetcode.com/problems/132-pattern/discuss/94071/Single-pass-C%2B%2B-O(n)-space-and-time-solution-(8-lines)-with-detailed-explanation.
    // From end of array
    // use second
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int second=Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            if (nums[i]<second)
                return true;
            else{
                // found new max
                while(!stack.isEmpty()&&nums[i]>nums[stack.peek()]){
                    int p=stack.pop();
                    second=Math.max(nums[p],second);
                }
            }
            stack.push(i);

        }
        return false;
    }
}
// @lc code=end

