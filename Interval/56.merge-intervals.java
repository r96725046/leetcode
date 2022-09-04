/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */
import java.util.*;
// @lc code=start
class Solution {
    // **
    //1. sort
    //2. int[][] res
    //1 
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)return intervals;
        Arrays.sort(intervals,(x,y)->Integer.compare(x[0],y[0]));

        int[] cur=intervals[0];
        List<int[]> list=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            int[] intv=intervals[i];
            if(cur[1]>=intv[0])
            {
                cur[0]=Math.min(cur[0],intv[0]);
                cur[1]=Math.max(cur[1],intv[1]);
            }else{
                list.add(cur);
                cur=intv;
            }
        }
        list.add(cur);
        int[][] res=new int[list.size()][2];
        for(int i=0;i<res.length;i++)
            res[i]=list.get(i);
        return res;
    }
}
// @lc code=end

