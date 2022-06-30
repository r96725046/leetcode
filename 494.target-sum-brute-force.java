/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
   
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==0)return 0;
       
        int res=dfs(nums,0,0,target);
        return res;
    }

    private int dfs(int[] nums,long sum,int index,int target){

        if(index==nums.length){
            if(sum==target)
                return 1;
            else 
                return 0;
        }
     
        int add=dfs(nums,sum+nums[index],index+1,target);
        int minus=dfs(nums,sum-nums[index],index+1,target);
        return add+minus;
    }
}
// @lc code=end

