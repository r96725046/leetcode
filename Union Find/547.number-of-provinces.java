/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited=new boolean[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i])
                count++;
            visited[i]=true;
            for(int j=0;j<isConnected[i].length;j++)
            {
                if(i!=j&&isConnected[i][j]==1)
                {
                    traversal(isConnected,visited,j);

                }
            }

        }
        return count;
    }
    public void traversal(int[][] isConnected,boolean[] visited,int j){

        if(visited[j])
            return;

        visited[j]=true;
        for(int i=0;i<isConnected[j].length;i++){
            if(i!=j&&isConnected[i][j]==1)
                traversal(isConnected,visited,i);
        }

    }
}
// @lc code=end

