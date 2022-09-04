/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    // **
    // 1.start from "1 and 2" chars
    String res="";
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            isPalindrome(s,i,i);
            isPalindrome(s,i,i+1);
        }
        return res;
    }
    private void isPalindrome(String s,int l,int r){
        
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r))
        {
            l--;
            r++;
        }   
        if(r-l-1>res.length())
            res=s.substring(l+1,r);
    }
}
// @lc code=end

