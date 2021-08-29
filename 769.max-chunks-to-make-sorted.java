/*
 * @lc app=leetcode id=769 lang=java
 *
 * [769] Max Chunks To Make Sorted
 */

// @lc code=start
class Solution {
    //Iterate the array, if the max(A[0] ~ A[i]) = i,
    //then we can split the array into two chunks at this index.
    // 1.max(cur,arr[i])
    public int maxChunksToSorted(int[] arr) {
        int cur=Integer.MIN_VALUE;
        int res=0;
        for(int i=0;i<arr.length;i++){
            cur=Math.max(cur,arr[i]);
            if(cur==i)
                res++;
        }
        return res;
    }
}
// @lc code=end

