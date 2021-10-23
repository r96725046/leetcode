/*
 * @lc app=leetcode id=1391 lang=java
 *
 * [1391] Check if There is a Valid Path in a Grid
 */

// @lc code=start
class Solution {
    int[][][] dir={
        {{0,1},{0,-1}},
        {{-1,0},{1,0}},
        {{0,-1},{1,0}},
        {{0,1},{1,0}},
        {{0,-1},{-1,0}},
        {{0,1},{-1,0}}
    };
    public boolean hasValidPath(int[][] grid) {

        boolean[][] visited=new boolean[grid.length][grid[0].length];
        return dfs(grid,visited,0,0,-1,-1);
    }
    public boolean dfs(int[][] grid,boolean[][] visited,int i,int j,int x,int y){

        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||visited[i][j])
            return false;
       
        visited[i][j]=true;
        boolean res=false;
        int[][] curDir=dir[grid[i][j]-1];
        boolean valid =false;
        for(int k=0;k<curDir.length;k++){
            if(x==-1&&y==-1)
                valid=true;
            if(i+curDir[k][0]==x&&j+curDir[k][1]==y)
                valid=true;
        }
        if(!valid)
            return false;
        if(i==grid.length-1&&j==grid[0].length-1)
            return true;

        for(int k=0;k<curDir.length;k++){
            int newX=i+curDir[k][0];
            int newY=j+curDir[k][1];
            res=res||dfs(grid,visited,newX,newY,i,j);
        }
        
        return res;

    }
}
// @lc code=end

