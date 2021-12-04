/*
 * @lc app=leetcode id=1584 lang=java
 *
 * [1584] Min Cost to Connect All Points
 */

// @lc code=start
class Solution {
    //Kruskal's algorithm using Union-Find
    public int minCostConnectPoints(int[][] points) {
        
        PriorityQueue<int[]> q=new PriorityQueue<>((x,y)->x[0]-y[0]);
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                q.offer(new int[]{distance(points,i,j),i,j});
            }
        }
        int res=0;
        UnionFind uf=new UnionFind(points.length);
        while(!q.isEmpty()){
            int[] edge=q.poll();

            if(uf.find(edge[1])!=uf.find(edge[2]))
            {
                res+=edge[0];
                uf.union(edge[1],edge[2]);
            }

        }
        return res;
    }
    private int distance(int[][] points,int i,int j){
        return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
    }
    class UnionFind{

        int[] parent;
        UnionFind(int n){
            this.parent=new int[n];
            for(int i=0;i<parent.length;i++)parent[i]=i;
        }
        public void union(int a,int b){
            parent[find(a)]=parent[find(b)];
        }
        public int find(int x){
            if (parent[x]!=x)
                return parent[x]=find(parent[x]);
            else
                return parent[x];
        }
    }

}
// @lc code=end

