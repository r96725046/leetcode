/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 */

// @lc code=start
class Solution {
    // ***remove duplicated
    // left >  right >=
    // int l=i-left[i];
    // int r=right[i]-i;
    // res=(res+arr[i]*l*r)%mod;
    public int sumSubarrayMins(int[] arr) {
        int[] left=new int[arr.length];
        int[] right=new int[arr.length];

        left[0]=-1;
        right[right.length-1]=right.length;

        for(int i=1;i<left.length;i++){
            int p=i-1;
            while(p>=0&&arr[p]>arr[i])
                p=left[p];
            left[i]=p;
        }
        for(int i=right.length-1;i>=0;i--){
            int p=i+1;
            while(p<right.length&&arr[p]>=arr[i])
                p=right[p];
            right[i]=p;
        }
        long res=0; 
        int mod=1000000007;
        for(int i=0;i<arr.length;i++){
            long l=i-left[i];
            long r=right[i]-i;
            res=(res+(long)arr[i]*l*r)%mod;
        }
        return (int)res;
    }
}
// @lc code=end

