/*
 * @lc app=leetcode id=2192 lang=java
 *
 * [2192] All Ancestors of a Node in a Directed Acyclic Graph
 */

// @lc code=start
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] in=new int[n];
        List<List<Integer>> graph=new ArrayList<>();

        Map<Integer,TreeSet<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
            map.put(i,new TreeSet<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            int[] edge=edges[i];
            graph.get(edge[0]).add(edge[1]);
            in[edge[1]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int cur=queue.poll();
            List<Integer> list=graph.get(cur);
            for(int i=0;i<list.size();i++){
                int dest=list.get(i);
                map.get(dest).add(cur);
                map.get(dest).addAll(map.get(cur));
                in[dest]--;
                if(in[dest]==0)
                    queue.offer(dest);
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<Integer>(map.get(i)));
        }
        return res;
    }
}
// @lc code=end

