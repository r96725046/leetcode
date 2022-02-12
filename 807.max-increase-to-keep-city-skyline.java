/*
 * @lc app=leetcode id=807 lang=java
 *
 * [807] Max Increase to Keep City Skyline
 */

// @lc code=start
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row=new int[grid.length];
        int[] col=new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                row[i]=Math.max(grid[i][j],row[i]);
                col[j]=Math.max(grid[i][j],col[j]);
            }
        }
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                res+=Math.min(row[i],col[j])-grid[i][j];
            }
        }
        return res;
    }
}
// @lc code=end

