/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    //Merge two sort arry
    public int[] sortedSquares(int[] nums) {
         int[] res=new int[nums.length];
        int l=0;
        int r=nums.length-1;
        int index=nums.length-1;
        while(index>=0){
            
            if(Math.abs(nums[l])>Math.abs(nums[r])){
                res[index]=nums[l]*nums[l];
                l++;
            }else{
                res[index]=nums[r]*nums[r];
                r--;
            }
            index--;
            
        }
        return res;
    }
}
// @lc code=end

