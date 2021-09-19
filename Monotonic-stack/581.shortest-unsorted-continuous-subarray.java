/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        Stack<Integer> stack=new Stack<>();
        int r=0;
        int l=nums.length;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                l=Math.min(l,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for(int j=nums.length-1;j>=0;j--){
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[j]){
                r=Math.max(r,stack.pop());
            }
            stack.push(j);
        }
        if(r-l<=0)
            return 0;
        else
            return r-l+1;

    }
}
// @lc code=end

