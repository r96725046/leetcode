/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    //1.int[] in=new int[numCourses];
    //2.List<List<Integer>> graph=new ArrayList<List<Integer>>();
    //3. edge 0 -> course, edge 1 -> prerequisite
    //4. Check edges of array List in incoming array
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] in=new int[numCourses];
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<Integer>());
        for(int i=0;i<prerequisites.length;i++){
            int[] edge=prerequisites[i];
            in[edge[0]]++;
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0)
                q.offer(i);
        }
        while(!q.isEmpty()){

            int cur=q.poll();
            numCourses--;
            for(int next:graph.get(cur)){
                in[next]--;
                if(in[next]==0)
                    q.offer(next);
            }
        }
        return numCourses==0;
    }
}
// @lc code=end

