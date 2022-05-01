/*
 * @lc app=leetcode id=1288 lang=java
 *
 * [1288] Remove Covered Intervals
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {


        Arrays.sort(intervals, (x,y)->
            (x[0]==y[0]?Integer.compare(y[1],x[1]):Integer.compare(x[0],y[0])));
        int[] cur=intervals[0];
        int merged=0;
        for(int i=1;i<intervals.length;i++){
            int[] interval=intervals[i];
            if(cur[0]<=interval[0]&&cur[1]>=interval[1]){
                merged++;
            }else if(cur[1]<interval[0]){
                cur=interval;
            }else{
                cur[0]=Math.min(cur[0],interval[0]);
                cur[1]=Math.max(cur[1],interval[1]);
            }
        }
        return intervals.length-merged;
    }
}
// @lc code=end

