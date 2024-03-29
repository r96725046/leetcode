/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */
import java.util.*;
// @lc code=start
class Solution {
    // **
    // 2
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int[] cur=newInterval;
        List<int[]> in=new ArrayList<>();
        //0. sort
        //1. newInterval before cur Interval
        //2. newUnterval after cur Interval
        //3. overlap
        //4. add cur
        for(int[] intv:intervals){

            if(cur[1]<intv[0]){
                in.add(cur);
                cur=intv;
            }else if(intv[1]<cur[0]){
                in.add(intv);
            }else{
                cur[0]=Math.min(cur[0],intv[0]);
                cur[1]=Math.max(cur[1],intv[1]);
            }
        }
        //add cur
        in.add(cur);
        int[][] res=new int[in.size()][2];
        for(int i=0;i<in.size();i++)
            res[i]=in.get(i);
        return res;
    }
}
// @lc code=end

