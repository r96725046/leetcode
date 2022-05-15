/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    class P{
        int[] point;
        int d=0;
        public P(int[] point,int d){
            this.point=point;
            this.d=d;
        }
        
    }
    public int[][] kClosest(int[][] points, int k) {
        P[] d=new P[points.length];
        for(int i=0;i<points.length;i++){
            int[] point=points[i];
            P p=new P(point,point[0]*point[0]+point[1]*point[1]);
            d[i]=p;
        }
        PriorityQueue<P> q=new PriorityQueue<>((x,y)->(y.d-x.d));

        for(int i=0;i<d.length;i++){
            q.offer(d[i]);
            if(q.size()>k)
                q.poll();
        }
        int[][] res=new int[k][2];
        for(int i=0;i<res.length;i++){
            res[i]=q.poll().point;
        }
        return res;
    }
}
// @lc code=end

