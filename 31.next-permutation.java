/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        // ***
        //1. find i+1>i break
        //2. from end to 0 > nums[i] break swap(i,index)
        //3. reverse 0 or i+1
        //2
        int index=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
         
        if(index>=0){
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[index]){
                    swap(nums,i,index);
                    break;
                }
            }
           
        }
       
        reverse(nums,index==-1?0:index+1,nums.length-1);
    }
    public void reverse(int[] nums,int i,int j){
        while(i<j)
            swap(nums,i++,j--);
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
// @lc code=end

