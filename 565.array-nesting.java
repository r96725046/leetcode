/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 */

// @lc code=start
class Solution {
    int max=1;
    public int arrayNesting(int[] nums) {
       
        for(int i=0;i<nums.length;i++){
            dfs(nums,i,0);
        }
        return max;
    }
    private void dfs(int[] nums,int index,int d){

        if(nums[index]==-1){
            max=Math.max(max,d);
            return;
        }
        int next=nums[index];
        nums[index]=-1;
        dfs(nums,next,d+1);
    }
}
// @lc code=end

