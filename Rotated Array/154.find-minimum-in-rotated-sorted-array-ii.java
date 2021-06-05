/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    // **
    // 1
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            if(mid>0&&nums[mid]<nums[mid-1])
                break;
            else if(nums[mid]<=nums[r])
                r=mid;
            else
                l=mid+1;
        }
        return nums[mid];
    }
}
// @lc code=end

