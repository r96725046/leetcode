/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    // ***
    // See [130] Surrounded Regions
    // 1. two boolean matrix
    // 2. start from all edges
    // 3. visit once
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;
        boolean[][] p=new boolean[row][col];
        boolean[][] a=new boolean[row][col];
        
        List<List<Integer>> list=new ArrayList<List<Integer>>();

        for(int i=0;i<row;i++){
            dfs(p,heights,heights[i][0],i,0);
            dfs(a,heights,heights[i][col-1],i,col-1);
        }
        for(int j=0;j<col;j++){
            dfs(p,heights,heights[0][j],0,j);
            dfs(a,heights,heights[row-1][j],row-1,j);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
            {
                if(p[i][j]&&a[i][j])
                {
                    List<Integer> ans=new ArrayList<Integer>();
                    ans.add(i);
                    ans.add(j);
                    list.add(ans);
                }
            }
        }
        return list;
    }
    public void dfs(boolean[][] visited,int[][] h,int pre,int i,int j){
        
        if(i<0||j<0||i>=h.length||j>=h[0].length){
            return;
        }
        if(visited[i][j]||pre>h[i][j])
            return;
        visited[i][j]=true;
        dfs(visited,h,h[i][j],i+1,j);
        dfs(visited,h,h[i][j],i,j+1);
        dfs(visited,h,h[i][j],i-1,j);
        dfs(visited,h,h[i][j],i,j-1);
    }
    
}
// @lc code=end

