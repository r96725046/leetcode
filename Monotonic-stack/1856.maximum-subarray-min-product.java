/*
 * @lc app=leetcode id=1856 lang=java
 *
 * [1856] Maximum Subarray Min-Product
 */

// @lc code=start
class Solution {
    public int maxSumMinProduct(int[] nums) {
        
        long[] sum=new long[nums.length];
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<sum.length;i++)
            sum[i]=nums[i]+sum[i-1];
        left[0]=-1;
        for(int i=1;i<left.length;i++){
            int p=i-1;
            while(p>=0&&nums[p]>=nums[i])
                p=left[p];
            left[i]=p;
        }
        right[right.length-1]=right.length;
        for(int i=right.length-2;i>=0;i--){
            int p=i+1;
            while(p<right.length&&nums[p]>=nums[i])
                p=right[p];
            right[i]=p;
        }
        long res=0;
        for(int i=0;i<nums.length;i++){
            int l=left[i]+1;
            int r=right[i]-1;
            res=Math.max(res,(sum[r]-(l>0?sum[l-1]:0))*nums[i]);
        }
        return (int)(res%(1000000007));

    }
}
// @lc code=end

