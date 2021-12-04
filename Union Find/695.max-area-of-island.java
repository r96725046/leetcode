/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    int max=0;
    int count=0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    count=0;
                    traversal(grid,visited,i,j);
                    max=Math.max(max,count);
                }
            }
        }
        return max;
    }
    public void traversal(int[][] grid, boolean[][]visited,int i,int j){

        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0||visited[i][j])
            return;
        visited[i][j]=true;
        count++;
    
        traversal(grid,visited,i+1,j);
        traversal(grid,visited,i,j+1);
        traversal(grid,visited,i-1,j);
        traversal(grid,visited,i,j-1);

    }
}
// @lc code=end

