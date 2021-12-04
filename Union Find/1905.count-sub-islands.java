/*
 * @lc app=leetcode id=1905 lang=java
 *
 * [1905] Count Sub Islands
 */

// @lc code=start
class Solution {
    int c1=0;
    int c2=0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count=0;
        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[0].length;j++){
                if(grid2[i][j]==1){
                    c1=0;
                    c2=0;
                    dfs(grid1,grid2,i,j);
                    if(c1==c2)
                        count++;
                }

            }

        }
        return count;
    }
    public void dfs(int[][] grid1,int[][] grid2,int i,int j){

        if(i<0||j<0||i>grid1.length-1||j>grid2[0].length-1||grid2[i][j]==0)
            return;

        if(grid1[i][j]==1)
            c1++;
        c2++;
        grid2[i][j]=0;
        dfs(grid1,grid2,i+1,j);
        dfs(grid1,grid2,i,j+1);
        dfs(grid1,grid2,i-1,j);
        dfs(grid1,grid2,i,j-1);
    }
}
// @lc code=end

