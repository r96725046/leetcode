/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */
import java.util.*;
// @lc code=start
class Solution {
    // **
    // 1.path.add(0)
    List<List<Integer>> list=new ArrayList<List<Integer>>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if(graph.length==0)return list;
        ArrayList<Integer> path=new ArrayList<Integer>();
        path.add(0);
        dfs(graph,0,path);
        return list;
    }
    private void dfs(int[][] graph,int index,ArrayList<Integer> res){
        if(index==graph.length-1){
            list.add(new ArrayList<Integer>(res));
            return;
        }
        int[] target=graph[index];
        for(int node:target){
            res.add(node);
            dfs(graph,node,res);
            res.remove(res.size()-1);
        }

    }
}
// @lc code=end

