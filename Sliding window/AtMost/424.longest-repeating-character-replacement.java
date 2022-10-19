/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    //j-i+1-max>k
    public int characterReplacement(String s, int k) {
        int start=0;
        int res=0;
        int max=0;
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            count[c-'A']++;
            max=Math.max(max,count[c-'A']);
            if(i-start+1-max>k){
                count[s.charAt(start)-'A']--;
                start++;
            }
            res=Math.max(res,i-start+1);
        }
        return res;
    }
}
// @lc code=end

