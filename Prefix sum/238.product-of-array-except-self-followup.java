/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){  
            if(i==0)
                res[i]=1;
            else
                res[i]=nums[i-1]*res[i-1];
        }
        int tmp=nums[nums.length-1];
        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1)
                nums[i]=1;
            else{
                int cur=nums[i];
                nums[i]=nums[i+1]*tmp;
                tmp=cur;
            }
        }
        for(int i=0;i<nums.length;i++)
           res[i]=nums[i]*res[i];
        return res;
    }
}
// @lc code=end

