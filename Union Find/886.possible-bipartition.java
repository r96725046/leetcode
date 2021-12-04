/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colors=new int[n+1];
        List<Integer>[] graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            graph[i]=new ArrayList<>();

        for(int[] edge : dislikes){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for(int i=1;i<=n;i++){
            if(colors[i]==0&&!dfs(graph,colors,1,i))
                return false;
        }
        return true;
    }

    public boolean dfs(List<Integer>[] graph,int[] colors, int color, int node){

        if(colors[node]==0)
            colors[node]=color;
        else
            return colors[node]==color;

        List<Integer> nextNodes=graph[node];
        for(int next:nextNodes)
        {
            if(!dfs(graph,colors,-color,next))
                return false;
        }
        return true;
    }
}
// @lc code=end

