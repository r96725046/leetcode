/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    // **
    // 1. cur[0] < pivot[1] count++
    // 2. interval=smaller end
    // Leecode 56 57
    public int eraseOverlapIntervals(int[][] intervals) {
        int count=0;
        Arrays.sort(intervals,(x,y)->Integer.compare(x[0],y[0]));
        int[] cur=intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] intv=intervals[i];
            if(intv[0]<cur[1]){
                count++;
                if(intv[1]<cur[1])cur=intv;
            }else{
                cur=intv;
            }
        }
        return count;
    }
}
// @lc code=end

