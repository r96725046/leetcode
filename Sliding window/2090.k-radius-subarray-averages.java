/*
 * @lc app=leetcode id=2090 lang=java
 *
 * [2090] K Radius Subarray Averages
 */

// @lc code=start
class Solution {
    public int[] getAverages(int[] nums, int k) {
        long[] prefix=new long[nums.length+1];
        int[] res=new int[nums.length];
        int cur=0;
        for(int i=1;i<prefix.length;i++){
            prefix[i]=nums[i-1]+prefix[i-1];
        }
        for(int i=0;i<nums.length;i++){
            if(i<k||i>=nums.length-k)
                res[i]=-1;
            else
                res[i]=(int)((prefix[i+k+1]-prefix[i-k])/(k*2+1));
        }
        return res;
    }
}
// @lc code=end

