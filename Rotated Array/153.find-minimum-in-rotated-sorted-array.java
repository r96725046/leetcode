/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    // **
    // mid>0&&nums[mid]<nums[mid-1]
    // 1
    public int findMin(int[] nums) {  
        int l=0;
        int r=nums.length-1;
        //l 0~nums.length
        //r -1~nums.length-1
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid>0&&nums[mid]<nums[mid-1])
                return nums[mid];
            else if(nums[mid]>nums[r])
                l=mid+1;
            else
                r=mid-1;
        }
        return nums[l];
    }
}
// @lc code=end

