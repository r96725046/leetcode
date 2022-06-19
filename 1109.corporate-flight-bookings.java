/*
 * @lc app=leetcode id=1109 lang=java
 *
 * [1109] Corporate Flight Bookings
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] r=new int[n];

        for(int i=0;i<bookings.length;i++){
            int[] booking=bookings[i];
            int start =booking[0];
            r[start-1]+=booking[2];
            if(booking[1]<n)
            {
                int end=booking[1];
                r[end]-=booking[2];
            }
        }

        for(int i=1;i<r.length;i++){
            r[i]+=r[i-1];
        }
        return r;
    }
}
// @lc code=end

