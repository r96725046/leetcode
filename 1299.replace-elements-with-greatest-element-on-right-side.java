/*
 * @lc app=leetcode id=1299 lang=java
 *
 * [1299] Replace Elements with Greatest Element on Right Side
 */

// @lc code=start
class Solution {
    public int[] replaceElements(int[] arr) {
        int max=-1;
        for(int i=arr.length-1;i>=0;i--)
        {
            int tmp=arr[i];
            arr[i]=max;
            max=Math.max(tmp,max);
        }
        return arr;
    }
}
// @lc code=end

