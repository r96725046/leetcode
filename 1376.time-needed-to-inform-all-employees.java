/*
 * @lc app=leetcode id=1376 lang=java
 *
 * [1376] Time Needed to Inform All Employees
 */

// @lc code=start
class Solution {
    int max=0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<manager.length;i++){
            int m=manager[i];
            if(!map.containsKey(m))
                map.put(m,new ArrayList<Integer>());
            map.get(m).add(i);
        }
        dfs(headID,informTime[headID],informTime,map);
        return max;
    }
    public void dfs(int head,int cur,int[] informTime,HashMap<Integer,List<Integer>> map){

        if(!map.containsKey(head)){
            max=Math.max(max,cur);
            return;
        }
        List<Integer> list=map.get(head);
        for(int sub:list){
            dfs(sub,cur+informTime[sub],informTime,map);
        }

    }
}
// @lc code=end

