/*
 * @lc app=leetcode id=576 lang=java
 *
 * [576] Out of Boundary Paths
 */

// @lc code=start
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp=new int[maxMove+1][m][n];
        int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int mod= 1000000007;
        for(int k=1;k<=maxMove;k++){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    int sum=0;
                    for(int[] d:dir){
                        int row=i+d[0];
                        int col=j+d[1];
                        if(row<0||col<0||row>=m||col>=n)
                            sum+=1;
                        else{
                            sum+=dp[k-1][row][col]%mod;
                        }
                        sum=sum%mod;
                    }
                    dp[k][i][j]=sum;
                }
            }
        }
        return dp[maxMove][startRow][startColumn];
    }
}
// @lc code=end

