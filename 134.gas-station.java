/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        for(int i=0;i<gas.length;i++)
            sum+=gas[i]-cost[i];
        if(sum<0)
            return -1;
        sum=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
            if(sum<0){
                sum=0;
                //start from next i
                start=i+1;
            }
        }
        if(start==gas.length)
            return 0;
        return start; 
    }
}
// @lc code=end

