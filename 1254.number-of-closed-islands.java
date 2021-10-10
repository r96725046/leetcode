/*
 * @lc app=leetcode id=1254 lang=java
 *
 * [1254] Number of Closed Islands
 */

// @lc code=start
class Solution {
    public int closedIsland(int[][] grid) {
        if(grid.length<=1||grid[0].length<=1)
            return 0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
                if((i==0||j==0||i==grid.length-1||j==grid[0].length-1)&&grid[i][j]==0)
                    fill(grid,i,j);
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]==0){
                    fill(grid,i,j);
                    count++;
                }
        }
        return count;
    }
    public void fill(int[][] grid,int i,int j){

        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==1)
            return; 
        grid[i][j]=1;

        fill(grid,i+1,j);
        fill(grid,i,j+1);
        fill(grid,i-1,j);
        fill(grid,i,j-1);
    }
}
// @lc code=end

