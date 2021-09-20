/*
 * @lc app=leetcode id=1574 lang=java
 *
 * [1574] Shortest Subarray to be Removed to Make Array Sorted
 */

// @lc code=start
class Solution {
    // 1. left highest
    // 2. right lowest
    // 3. search both side
    public int findLengthOfShortestSubarray(int[] arr) {
        int left=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1])
                break;
            else
                left=i;
        }
        if(left==arr.length-1)return 0;
        int right=arr.length-1;
        for(;right>left;right--){
            if(arr[right-1]>arr[right])
                break;
        }
        int i=0;
        int j=right;
        int res=Math.min(arr.length-left-1,right);
        while(i<=left&&j<arr.length){
            if(arr[i]<=arr[j]){
                res=Math.min(res,j-i-1);
                i++;
            }else
                j++;
        }
        return res;
    }
}
// @lc code=end

