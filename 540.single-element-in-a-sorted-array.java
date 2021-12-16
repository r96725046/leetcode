/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)return nums[0];
        int l=0;
        int r=nums.length-1;

        while(l<=r){

            int mid=(l+r)/2;
            if(mid==0&&(mid+1>r||nums[mid]!=nums[mid+1]))
                return nums[mid];
            if(mid==nums.length-1&&(mid-1<l||nums[mid]!=nums[mid-1]))
                return nums[mid];
            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1])
                return nums[mid];

            if(mid%2==0)
            {
                if(nums[mid]!=nums[mid+1])
                    r=mid-1;
                else
                    l=mid+1;
            }else
            {
                if(nums[mid]!=nums[mid-1])
                    r=mid-1;
                else
                    l=mid+1;
            }

        }

        return -1;
    }
}
// @lc code=end

