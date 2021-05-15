/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
    
        int l=0;
        int r=nums.length-1;
        int mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            //if min is not nums[0]
            if(mid>0&&nums[mid]<nums[mid-1])
                break;

            if(nums[mid]<nums[r])
                r=mid-1;
            else
                l=mid+1;

        }

        return nums[mid];

    }
}
// @lc code=end

