/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        // ***
        //1.init word lenght
        //2.i for deletion , j for insert, ij for change
        //3.be careful about word index
        //4."1" + Min of 3
        int[][] dp=new int[word1.length()+1][word2.length()+1];
       
        for(int i=0;i<dp.length;i++)
            dp[i][0]=i;
        for(int j=0;j<dp[0].length;j++)
            dp[0][j]=j;
    
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
               
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
// @lc code=end

