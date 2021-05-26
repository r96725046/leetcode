/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        
        
        int i;
        //first i<i+1
        for(i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1])
                break;
        }
        int j;
        if(i>=0){
            //first j>i from end of list
            for(j=nums.length-1;j>i;j--)
            {
                if(nums[j]>nums[i]){
                    swap(nums,i,j);
                    break;
                }
            }
        }    
        reverse(nums,i<0?0:i+1,nums.length-1);
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public void reverse(int[] nums,int i,int j){
        while(i<j)
            swap(nums,i++,j--);
    }
}
// @lc code=end

