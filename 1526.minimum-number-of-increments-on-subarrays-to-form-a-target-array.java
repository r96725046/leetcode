/*
 * @lc app=leetcode id=1526 lang=java
 *
 * [1526] Minimum Number of Increments on Subarrays to Form a Target Array
 */

// @lc code=start
class Solution {
    public int minNumberOperations(int[] target) {
        int count=target[0];
        
        for(int i=1;i<target.length;i++){
            count+=Math.max(target[i]-target[i-1],0);
        }
        return count;
    }
}
// @lc code=end
