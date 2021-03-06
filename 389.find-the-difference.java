/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        char c=t.charAt(t.length()-1);
        for(int i=0;i<s.length();i++){
            c^=s.charAt(i);
            c^=t.charAt(i);
        }
        return c;
    }
}
// @lc code=end

