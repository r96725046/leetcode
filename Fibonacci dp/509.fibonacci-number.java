/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int n) {

        if(n<=1)
            return n;
        
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++)
            dp[i]=dp[i-1]+dp[i-2];

        return dp[n];
    }
}
// @lc code=end

