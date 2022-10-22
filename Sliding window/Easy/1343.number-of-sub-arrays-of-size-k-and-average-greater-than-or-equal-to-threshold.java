/*
 * @lc app=leetcode id=1343 lang=java
 *
 * [1343] Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 */

// @lc code=start
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int[] sum=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            if(i==0)
                sum[i]=arr[i];
            else
                sum[i]=arr[i]+sum[i-1];
        }
        int res=0;
        for(int i=k-1;i<sum.length;i++){
            double avg=0.0;
            if(i-k<=0)
                avg=sum[i]/k;
            else
                avg=(sum[i]-sum[i-k])/k;
            if(avg>=(threshold*1.0))
                res++;
        }
        return res;

    }
}
// @lc code=end

