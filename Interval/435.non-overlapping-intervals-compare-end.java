/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    // **
    // Leecode 56 57
    public int eraseOverlapIntervals(int[][] intervals) {
        int count=1;
        Arrays.sort(intervals,(x,y)->Integer.compare(x[1],y[1]));
        int[] cur=intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] intv=intervals[i];
            if(intv[0]>=cur[1]){
                count++;
                cur=intv;
            }
        }
        return intervals.length-count;
    }
}
// @lc code=end

