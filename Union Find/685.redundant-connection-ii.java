/*
 * @lc app=leetcode id=685 lang=java
 *
 * [685] Redundant Connection II
 */

// @lc code=start
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {

        int[] parent=new int[edges.length+1];
        int multiParentNode=-1;
        for(int i=0;i<edges.length;i++){
            int[] edge=edges[i]; 
            if(parent[edge[1]]==0)
                parent[edge[1]]=edge[0];
            else{
                multiParentNode=edge[1];
            }
        }
        if(multiParentNode==-1)
            return findConnection(edges,-1);
        else{
            for(int i=edges.length-1;i>=0;i--){
                if(edges[i][1]==multiParentNode)
                {
                    int[] res=findConnection(edges,i);
                    if(res==null)return edges[i];
                }

            }
        }
        return null;
       
    }

    public int[] findConnection(int[][] edges,int skip)
    {
        int[] parent=new int[edges.length+1];
        for(int i=0;i<parent.length;i++)
            parent[i]=i;
        for(int i=0;i<edges.length;i++){
            if(i==skip)continue;
            int[] edge=edges[i];
            if(find(parent,edge[0])==edge[1])
                return edge;
            parent[edge[1]]=edge[0];
        }
        return null;

    }

    public int find(int[] parent,int i)
    {
        if(parent[i]==i)
            return i;
        else 
            return find(parent,parent[i]);
    }
}
// @lc code=end

