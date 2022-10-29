/*
 * @lc app=leetcode id=2134 lang=java
 *
 * [2134] Minimum Swaps to Group All 1's Together II
 */

// @lc code=start
class Solution {
    public int minSwaps(int[] nums) {
        int ones=0;
        for(int v:nums)
            ones+=v;
        if(ones==nums.length||ones==0)
            return 0;
        int[] nums2=new int[nums.length*2];
        for(int i=0;i<nums2.length;i++){
            if(i>=nums.length)
                nums2[i]=nums[i-nums.length];
            else
                nums2[i]=nums[i];
        }
        int start=0;
        int count=0;
        int res=nums.length;
        for(int i=0;i<nums2.length;i++){
            if(nums2[i]==1)
                count++;
            if(i-start+1==ones){
                res=Math.min(res,ones-count);
                if(nums2[start]==1)
                    count--;
                start++;
            }
            
        }
        return res;
    }
}
// @lc code=end

