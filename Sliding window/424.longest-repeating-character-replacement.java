/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    //j-i+1-max>k
    public int characterReplacement(String s, int k) {
        int i=0;
        int res=0;
        int max=0;
        int[] count=new int[26];
        for(int j=0;j<s.length();j++){
            max=Math.max(max,++count[s.charAt(j)-'A']);
            while(j-i+1-max>k){
                count[s.charAt(i)-'A']--;
                i++;
            }
            res=Math.max(res,j-i+1);
        }
        return res;
    }
}
// @lc code=end

