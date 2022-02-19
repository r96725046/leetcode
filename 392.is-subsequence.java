/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
            if(s.length()==0)return true;
            int i=0;
            int j=0;

            while(j<t.length()){
                if(s.charAt(i)==t.charAt(j)){
                    i++;
                    if(i==s.length()-1)return true;
                }
                j++;
            }
            return false;
    }
}
// @lc code=end

