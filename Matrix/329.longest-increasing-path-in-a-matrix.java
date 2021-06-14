/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        int[][] cache=new int[matrix.length][matrix[0].length];
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int n=dfs(matrix,cache,i,j,Integer.MIN_VALUE);
                max=Math.max(max,n);
            }
        }
        return max;
    }
    private int dfs(int[][] matrix,int[][] cache, int i,int j,int pre){

        if(i<0||j<0||i>matrix.length-1||j>matrix[0].length-1||matrix[i][j]<=pre) return 0;
        if(cache[i][j]>0)
            return cache[i][j];
        int max=0;
        int[][] dir=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        for(int[] d:dir){
            int n=dfs(matrix,cache,i+d[0],j+d[1],matrix[i][j]);
            max=Math.max(max,n);
        }
        cache[i][j]=max+1;
        return cache[i][j];
    }
}
// @lc code=end

