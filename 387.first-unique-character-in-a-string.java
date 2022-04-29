/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] c=new int[26];
        for(int i=0;i<s.length();i++){
            int v=s.charAt(i)-'a';
            c[v]++;
        }
        for(int i=0;i<s.length();i++)
        {
            int v=s.charAt(i)-'a';
            if(c[v]==1)return i;
        }
        return -1;
    }
}
// @lc code=end

