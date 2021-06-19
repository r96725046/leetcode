/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    // **
    // 1.colors[i]==0&&!dfs(graph,colors,1,i)
    // https://www.youtube.com/watch?v=670Gn4e89B8
    public boolean isBipartite(int[][] graph) {
        int[] colors=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(colors[i]==0&&!dfs(graph,colors,1,i))
                return false;
        }
        return true;
    }
    private boolean dfs(int[][] graph,int[] colors, int color, int node){
        if(colors[node]==0)
            colors[node]=color;
        else
            return colors[node]==color;

        int[] nextNodes=graph[node];
        for(int next:nextNodes){
            if(!dfs(graph,colors,-color,next))
                return false;
        }
        return true;
    }
}
// @lc code=end

