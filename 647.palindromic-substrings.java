/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    // **
    // 1.i<s.length() && i+1 is ok
    // 2.while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j))
    // 1
    int res=0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            check(s,i,i);
            check(s,i,i+1);
        }   
        return res;
    }
    public void check(String s,int i,int j){

        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
            res++;
        }

    }
}
// @lc code=end

