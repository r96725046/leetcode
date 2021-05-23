/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */
import java.util.*;
// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;     
        Arrays.sort(intervals,(x,y)->Integer.compare(x[0],y[0]));
        int[] cur=intervals[0];
        List<int[]> list=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){

            if(intervals[i][0]>cur[1]){
                list.add(cur);
                cur=intervals[i];
            }else{
                cur[0]=Math.min(cur[0],intervals[i][0]);
                cur[1]=Math.max(cur[1],intervals[i][1]);
            }

        }
        list.add(cur);

        int[][] res=new int[list.size()][2];
        for(int i=0;i<list.size();i++)
            res[i]=list.get(i);
        return res;

    }
}
// @lc code=end

