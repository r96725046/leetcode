/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res=new ArrayList<>();
        int[] in=new int[numCourses];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<Integer>());

        for(int i=0;i<prerequisites.length;i++){
            int[] edge=prerequisites[i];
            in[edge[0]]++;
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<in.length;i++)
            if(in[i]==0)q.offer(i);
        
        while(!q.isEmpty()){
            int cur=q.poll();
            numCourses--;
            res.add(cur);
            for(int next:graph.get(cur)){
                in[next]--;
                if(in[next]==0)q.offer(next);
            }
        }

        if(numCourses!=0)
            return new int[0];
        int[] resArr=new int[res.size()];
        for(int i=0;i<res.size();i++)
            resArr[i]=res.get(i);
        return resArr;
    }
}
// @lc code=end

