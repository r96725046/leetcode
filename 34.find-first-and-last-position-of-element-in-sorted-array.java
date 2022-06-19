/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[]{-1,-1};

        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(r-l)/2+l;
            if(nums[mid]==target)
                r=mid-1;
            else if(nums[mid]>target)
                r=mid-1;
            else
                l=mid+1;
        }
        if(l<nums.length&&nums[l]==target)
            res[0]=l;

        l=0;
        r=nums.length-1;
        while(l<=r){
            int mid=(r-l)/2+l;
            if(nums[mid]==target)
                l=mid+1;
            else if(nums[mid]>target)
                r=mid-1;
            else
                l=mid+1;
        }
        if(r>=0&&nums[r]==target)
            res[1]=r;
        return res;
    }
}
// @lc code=end

