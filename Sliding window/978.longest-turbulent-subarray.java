/*
 * @lc app=leetcode id=978 lang=java
 *
 * [978] Longest Turbulent Subarray
 */

// @lc code=start
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int[] increase=new int[arr.length];
        int[] decrease=new int[arr.length];
        increase[0]=1;
        decrease[0]=1;
        int max=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                increase[i]=decrease[i-1]+1;
                decrease[i]=1;
            }else if(arr[i]<arr[i-1]){
                decrease[i]=increase[i-1]+1;
                increase[i]=1;
            }else{
                decrease[i]=1;
                increase[i]=1;
            }
            max=Math.max(max,Math.max(decrease[i],increase[i]));
        }
        return max;
    }
}
// @lc code=end

