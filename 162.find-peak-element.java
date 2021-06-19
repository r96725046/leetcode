/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        
        int l=0;
        int r=nums.length-1;
        if(nums.length==0)return -1;
        if(nums.length==1)return 0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid==0&&nums[mid]>nums[mid+1])
                return mid;
            else if(mid==nums.length-1&&nums[mid]>nums[mid-1])
                return mid;
            else if(nums[mid]<nums[mid+1])
                l=mid+1;
            else
                r=mid-1;
        }
        return l;
    }
}
// @lc code=end

