/*
 * @lc app=leetcode id=1319 lang=java
 *
 * [1319] Number of Operations to Make Network Connected
 */

// @lc code=start
class Solution {
    // 1.build the graph
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        List<Integer>[] graph=new List[n];
        boolean[] visited=new boolean[n];
        for(int i=0;i<graph.length;i++)
            graph[i]=new ArrayList<Integer>();
        for(int[] v:connections){
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph,visited,i);
                count++;
            }
        }
        return count-1;
    }
    public void dfs(List<Integer>[] graph,boolean[] visited,int i){
        if(visited[i])
            return;
        visited[i]=true;
        for(int v:graph[i]){
            dfs(graph,visited,v);
        }

    }
}
// @lc code=end

