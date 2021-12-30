/*
 * @lc app=leetcode id=841 lang=java
 *
 * [841] Keys and Rooms
 */

// @lc code=start
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited=new boolean[rooms.size()];
        dfs(rooms,0,visited);
        for(int i=0;i<visited.length;i++)
            if(!visited[i])return false;

        return true;
    }
    private void dfs(List<List<Integer>> rooms,int index,boolean[] visited){
        if(visited[index])return ;
        visited[index]=true;
        List<Integer> keys=rooms.get(index);
        for(int key:keys)
            dfs(rooms,key,visited);

    }
}
// @lc code=end

