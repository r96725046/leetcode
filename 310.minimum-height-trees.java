/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res=new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }
        List<List<Integer>> graph=new ArrayList<>();
        int[] out=new int[n];
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int[] edge=edges[i];
            out[edge[0]]++;
            out[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<out.length;i++){
            if(out[i]==1)
                q.offer(i);
        }
       
        while(!q.isEmpty()){
            int size=q.size();
            res=new ArrayList<>();
            for(int i=0;i<size;i++){
                int v=q.poll();
                res.add(v);
                List<Integer> next=graph.get(v);
                for(int j=0;j<next.size();j++){
                    int index=next.get(j);
                    out[index]--;
                    if(out[index]==1)
                        q.offer(index);
                }
            }
        }
        return res;
    }
}
// @lc code=end

