/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    // ****
    public boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int j=1;j<dp[0].length;j++)
            if(p.charAt(j-1)=='*'&&dp[0][j-2])dp[0][j]=true;

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(dp[i-1][j-1]&&(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')){
                    dp[i][j] = true;
                } else if(p.charAt(j - 1) == '*'){
                        if(dp[i][j-2])
                            dp[i][j]=true;
                        if (dp[i-1][j]&&(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.'))
                            dp[i][j]=true;
                }else
                    dp[i][j]=false;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
// @lc code=end

