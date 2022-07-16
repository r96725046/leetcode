/*
 * @lc app=leetcode id=576 lang=java
 *
 * [576] Out of Boundary Paths
 */

// @lc code=start
class Solution {
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] mem=new int[m][n][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<=maxMove;k++)
                    mem[i][j][k]=-1;
            }
        }
        return dfs(m,n,maxMove,startRow,startColumn,mem);
    }
    public int dfs(int m,int n,int max,int row,int col,int[][][] mem){

        if(row<0||col<0||row>=m||col>=n)
            return 1;
        if(max<=0)
            return 0;
        if(mem[row][col][max]!=-1)
            return mem[row][col][max];

        int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int sum=0;
        int mod=1000000007;
        for(int[] d:dir){
            int i=row+d[0];
            int j=col+d[1];
            sum+=dfs(m,n,max-1,i,j,mem)%mod;
            sum=sum%mod;
        }
        mem[row][col][max]=sum;
        return sum;
    } 
}
// @lc code=end

