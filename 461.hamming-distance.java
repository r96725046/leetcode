/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int xor=x^y;
        int count=0;
        while(xor!=0)
        {
            xor=xor&(xor-1);
            //xor=xor&1;
            //xor=xor>>1;
            count++;
        }
        return count;
    }
}
// @lc code=end

