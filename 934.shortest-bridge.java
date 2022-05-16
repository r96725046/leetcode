/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 */

// @lc code=start
class Solution {
    int[][] dir=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    int res=0;
    public int shortestBridge(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        Queue<int[]> q=new LinkedList<>();
        boolean found=false;

        for(int i=0;i<grid.length;i++){
            if(found)break;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,visited,q,i,j);
                    found=true;
                    break;
                }
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] cur=q.poll();
                for(int[] d:dir){
                    int i=cur[0]+d[0];
                    int j=cur[1]+d[1];
                    if(i>=0&&j>=0&&i<grid.length&&j<grid[0].length&&!visited[i][j]){
                        if(grid[i][j]==1)return res;
                        q.offer(new int[]{i,j});
                        visited[i][j]=true;
                    }
                }

            }
            res++;
        }
        return -1;
    }
    private void dfs(int[][] grid,boolean[][] visited,Queue<int[]> q,int i,int j){
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]==0)return;
        if(visited[i][j])return;

        visited[i][j]=true;
        q.offer(new int[]{i,j});

        for(int[] d:dir){
            dfs(grid,visited,q,i+d[0],j+d[1]);
        }

    }
}
// @lc code=end

