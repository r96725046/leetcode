/*
 * @lc app=leetcode id=1559 lang=java
 *
 * [1559] Detect Cycles in 2D Grid
 */

// @lc code=start
class Solution {
    // 1.pass last seen cell
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]){
                    if(dfs(grid,visited,i,j,-1,-1,grid[i][j]))
                        return true;
                }
            }
        }
        return false;
    }
    int[] dirX={1,0,-1,0};
    int[] dirY={0,1,0,-1};
    public boolean dfs(char[][] grid,boolean[][] visited,int i,int j,int x,int y,char c){

        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||c!=grid[i][j])
            return false;

        if(visited[i][j])
            return true;

        visited[i][j]=true;
        boolean res=false;
        for(int k=0;k<dirX.length;k++){
            int nextX=i+dirX[k];
            int nextY=j+dirY[k];
            if(!(nextX==x&&nextY==y))
                res=res||dfs(grid,visited,nextX,nextY,i,j,c);
        }
        return res;
    }
}
// @lc code=end

