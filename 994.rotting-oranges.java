/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    //m-1:oranges we push into queue last time 
    //are already rotten by setting grid[row][col] = 2
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int count=0;
        int m=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
                if(grid[i][j]==1)
                    count++;
            }
        }
        if(count==0)return 0;
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cell=q.poll();
                for(int[] d:dir){
                    int x=cell[0]+d[0];
                    int y=cell[1]+d[1];
                    if(x<0||y<0||x>grid.length-1||y>grid[0].length-1||grid[x][y]==0||grid[x][y]==2)
                        continue;
                    count--;
                    grid[x][y]=2;
                    q.offer(new int[]{x,y});
                }

            }
            m++;
        }
        if(count==0)return m-1;
        return -1;
    }
}
// @lc code=end

