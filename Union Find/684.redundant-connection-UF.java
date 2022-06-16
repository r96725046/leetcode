/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    class UF{
        int[] parent;
        public UF(int n){
            parent=new int[n];
            for(int i=0;i<parent.length;i++)
                parent[i]=i;
        }
        public int find(int i){
            if(parent[i]==i)
                return i;
            return find(parent[i]);

        }
        public void union(int x,int y){
            int l=find(x);
            int r=find(y);
            if(l!=r)
                parent[l]=r;
        }

    }
    public int[] findRedundantConnection(int[][] edges) {
        UF uf=new UF(edges.length+1);
        int[] res=new int[0];
        for(int i=0;i<edges.length;i++){
            int[] edge=edges[i];
            int l=uf.find(edge[0]);
            int r=uf.find(edge[1]);
            if(l==r)
                return edge;
            uf.union(edge[0],edge[1]);
                
        }
     
        return new int[0];
    }
   
}
// @lc code=end

