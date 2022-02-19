/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        if(s3.length() != s1.length() + s2.length())
            return false;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0&&j==0)
                    dp[i][j]=true;
                else if(i==0)
                    dp[i][j]=dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(j-1);
                else if(j==0)
                    dp[i][j]=dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i-1);
                else
                    dp[i][j]=(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(j-1+i))||
                            (dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i-1+j));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
// @lc code=end

