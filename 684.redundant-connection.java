/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents=new int[edges.length+1];
        for(int i=0;i<parents.length;i++)
            parents[i]=i;
        int[] res=new int[0];
        for(int i=0;i<edges.length;i++){
            int x=find(edges[i][0],parents);
            int y=find(edges[i][1],parents);
            if(x==y)
                res=edges[i];
            else
                parents[x]=y;
        }
        return res;
    }
    public int find(int i, int[] parents){

        if(parents[i]==i)
            return i;
        else return find(parents[i],parents);

    }
}
// @lc code=end

