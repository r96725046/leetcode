/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    // ****
    // Example:
    // S: xxx
    // P: xx*
    //   '' x x *
    // '' T F F F
    //  x F T F F
    //  x F F T T
    //  x F F F T

    // For i=3, j=3: s[i] is x, p[i] is *
    // dp[3][3] = dp[2][3] || dp[3][2]
    // dp[2][3] means we use the match from s: xx and p: xx* (notice 1 less char in s)
    // dp[3][2] means we use the match from s: xxx and p: xx (notice 1 less char in p)
    // dp[2][3] is true hence this ends up being a match
    // for dp[i-1][j], means that * acts like any sequences.
    // eg: abcd, ab*

    // for dp[i][j-1], means that * acts like an empty sequence
    // eg: ab, ab*

    public boolean isMatch(String s, String p) {
      boolean[][] dp = new boolean[s.length()+1][p.length()+1];
      dp[0][0] = true;
      for(int j = 1; j < dp[0].length; j++){
        if(p.charAt(j - 1) == '*'&&dp[0][j-1]) dp[0][j] = true
      }   
      
      for(int i = 1; i < dp.length; i++){
        for(int j = 1; j < dp[0].length; j++){
          if(dp[i-1][j-1]&&(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?')){
            dp[i][j] = true;
          } else if(p.charAt(j - 1) == '*'){
            dp[i][j] = dp[i][j - 1]||dp[i - 1][j];
          } else {
            dp[i][j] = false;
          }
        }
      }
      return dp[dp.length-1][dp[0].length-1];
    }
}
// @lc code=end

