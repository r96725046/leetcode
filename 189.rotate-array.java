/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    //Reverse array & k=k%nums.length
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums,int i,int j){

        while(i<j){

            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            i++;
            j--;
        }

    }
}
// @lc code=end

