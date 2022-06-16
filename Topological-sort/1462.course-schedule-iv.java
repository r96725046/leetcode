/*
 * @lc app=leetcode id=1462 lang=java
 *
 * [1462] Course Schedule IV
 */

// @lc code=start
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] in=new int[numCourses];
        List<List<Integer>> graph=new ArrayList<List<Integer>>();
        HashMap<Integer,Set<Integer>> map=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
            map.put(i,new HashSet<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int[] cur=prerequisites[i];
            in[cur[1]]++;
            graph.get(cur[0]).add(cur[1]);
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<in.length;i++)
        {
            if(in[i]==0)
                queue.offer(i);
        }
       
        
        int seq=0;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            List<Integer> out=graph.get(cur);
            for(int i=0;i<out.size();i++){
                int dest=out.get(i);
                map.get(dest).add(cur);
                map.get(dest).addAll(map.get(cur));
                in[dest]--;
                if(in[dest]==0)
                    queue.offer(dest);
            }
            
        }
        List<Boolean> res=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int[] query=queries[i];
            if(map.get(query[1]).contains(query[0]))
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}
// @lc code=end

