/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        int l=0;
        int r=nums.length-1;
        //four cases
        while(l<=r){

            int mid=(l+r)/2;

            if(nums[mid]==target)
                return mid;    
            
            if(nums[mid]<nums[r]){
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

        return -1;
    }
}
// @lc code=end

