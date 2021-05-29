/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    int start=0;
    int maxLen=0;
    public String longestPalindrome(String s) {
        //1.1 char or 2 chars

        for(int i=0;i<s.length();i++)
        {
            check(s,i,i);
            check(s,i,i+1);
        }

        return s.substring(start,start+maxLen);
    }

    public void check(String s, int l,int r){
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r))
        {
            l--;
            r++;
        }

        if(r-l-1>maxLen){
            maxLen=r-l-1;
            start=l+1;
        }
    }

}
// @lc code=end

