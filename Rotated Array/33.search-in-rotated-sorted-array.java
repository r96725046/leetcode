/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    // ** 
    // 1.mid , r
    // 2.mid , target & r, target
    public int search(int[] nums, int target) {
        
        if(nums.length==0)
            return -1;
        int l=0;
        int r=nums.length-1;
        int mid=0;
        while(l<=r){
            mid=l+(r-l)/2;

            if(nums[mid]==target)
                return mid;

            if(nums[mid]<nums[r]){
                //check increasing seq only
                if(target>nums[mid]&&target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }else{
                 //check increasing seq only
                if(target<nums[mid]&&target>=nums[l]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
        }

        return -1;
    }
}
// @lc code=end

