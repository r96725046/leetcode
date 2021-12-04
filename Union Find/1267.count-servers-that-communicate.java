/*
 * @lc app=leetcode id=1267 lang=java
 *
 * [1267] Count Servers that Communicate
 */

// @lc code=start
class Solution {
    public int countServers(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int res=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(row[i]<=1&&col[j]<=1)
                        continue;
                    else
                        res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

