/*
 * @lc app=leetcode id=849 lang=java
 *
 * [849] Maximize Distance to Closest Person
 */

// @lc code=start
class Solution {
    public int maxDistToClosest(int[] seats) {
        int last=-1;
        int max=0;

        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                max=last==-1?i:Math.max(max,(i-last)/2);
                last=i;
            }
        }
        max=Math.max(max,seats.length-last-1);
        return max;
        
    }
}
// @lc code=end

