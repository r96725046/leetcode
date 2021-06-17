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
        int[] interval=intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] cur=intervals[i];
            if(cur[0]<interval[1]){
                count++;
                if(cur[1]<interval[1])interval=cur;
            }else{
                interval=cur;
            }
        }
        return count;
    }
}
// @lc code=end

