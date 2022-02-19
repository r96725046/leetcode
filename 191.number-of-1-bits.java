/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    //in the while condition and we cannot use
    //n>0
    //because the input 2147483648 would correspond to -2147483648
    public int hammingWeight(int n) {
        int c=0;
        while(n!=0){
            if((n&1)>0)
                c++;
            n=n>>>1;
        }
        return c;
    }
}
// @lc code=end

