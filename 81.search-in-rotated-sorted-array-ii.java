/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        
        int l=0;
        int r=nums.length-1;
        int mid=0;
        while(l<=r){
            mid=l+(r-l)/2;

            if(nums[mid]==target)
                return true;
            else if(nums[mid]==nums[r])
                r--;
            else if(nums[mid]<nums[r]){
                if(target>nums[mid]&&target<=nums[r])
                    l=mid+1;
                else
                    r=mid-1;
            }else{
                if(target<nums[mid]&&target>=nums[l])
                    r=mid-1;
                else
                    l=mid+1;
            }
        }
        return false;
    }
}
// @lc code=end

