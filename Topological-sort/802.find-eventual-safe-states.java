/*
 * @lc app=leetcode id=802 lang=java
 *
 * [802] Find Eventual Safe States
 */

// @lc code=start
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] out=new int[graph.length];
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
            list.add(new ArrayList<Integer>());
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                list.get(graph[i][j]).add(i);
            }
           
            out[i]=graph[i].length;
        }
  
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(out[i]==0)
                q.offer(i);
        }
        List<Integer> res=new ArrayList<>();
        Set<Integer> set=new TreeSet<>();
        while(!q.isEmpty()){
            int cur=q.poll();
            set.add(cur);
            // Add cur to res and sort,or tree set, or add items after completing operation
            List<Integer> in=list.get(cur);
            for(int i=0;i<in.size();i++){
                int s=in.get(i);
                out[s]--;
                if(out[s]==0)
                    q.offer(s);
            }
        }
        // for(int i=0;i<out.length;i++)
        // {
        //     if(out[i]==0)
        //         res.add(i);
        // }
        res.addAll(set);
        return res;
    }
}
// @lc code=end

