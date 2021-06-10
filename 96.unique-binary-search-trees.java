/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    // ***
    // f0=1
    // f1=1
    // f2=f0*f1+f1*f0 j=>0->n-1 res[j-1]*res[i-j-1]
    // f3=f0*f2+f1*f1+f2*f0
    // loop
    public int numTrees(int n) {
        int[] res=new int[n+1];
        res[0]=1;
        res[1]=1;

        for(int i=2;i<=n;i++)
            for(int j=0;j<i;j++)
                res[i]+=res[j]*res[i-j-1];
        return res[n];
    }
}
// @lc code=end

