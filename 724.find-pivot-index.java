/*
 * @lc app=leetcode id=724 lang=java
 *
 * [724] Find Pivot Index
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length==1)return 0;
        long[] sum=new long[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<sum.length;i++){
            sum[i]=sum[i-1]+nums[i];
        }
        
        for(int i=0;i<sum.length;i++){
            long left=i==0?0:sum[i-1];
            long right=i==sum.length-1?0:sum[sum.length-1]-sum[i];
            if(left==right)return i;
        }
        return -1;
    }
}
// @lc code=end

