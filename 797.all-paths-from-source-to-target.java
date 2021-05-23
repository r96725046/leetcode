/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */
import java.util.*;
// @lc code=start
class Solution {
    List<List<Integer>> list=new ArrayList<List<Integer>>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph,0,new ArrayList<Integer>());
        return list;
    }
    public void dfs(int[][] graph,int index,ArrayList<Integer> cur){
        cur.add(index);
        if(index==graph.length-1)
            list.add(new ArrayList<Integer>(cur));
        int[] nodes=graph[index];

        for(int node:nodes){
            dfs(graph,node,cur);
        }
        cur.remove(cur.size()-1);
    }
}
// @lc code=end

