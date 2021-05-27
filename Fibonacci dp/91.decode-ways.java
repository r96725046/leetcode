/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        
        if(s.length()==0||s.charAt(0)=='0')
            return 0;

        int[] dp=new int[s.length()+1];
        dp[0]=1;
        int i=s.charAt(0)-'0';
        if(i>0&&i<=9)
            dp[1]=1;

        for(int j=2;j<=s.length();j++){

            int d=s.charAt(j-1)-'0';
            int e=s.charAt(j-2)-'0';
            int value=e*10+d;
            if(d>0&&d<=9)
                dp[j]+=dp[j-1];
            if(value>=10&&value<=26)
                dp[j]+=dp[j-2];
            
        }
        return dp[dp.length-1];
    }
}
// @lc code=end

