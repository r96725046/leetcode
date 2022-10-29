/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        int res=0;
        for(int p=0;p<26;p++){
            int[] count=new int[26];

            int unique=0;
            int total=0;
            int start=0;
            for(int i=0;i<s.length();i++){

                int c=s.charAt(i)-'a';
                count[c]++;
                if(count[c]==1)
                    unique++;
                if(count[c]==k)
                    total++;

                while(unique>p){
                    c=s.charAt(start)-'a';
                    count[c]--;
                    if(count[c]==0)
                        unique--;
                    if(count[c]==k-1)
                        total--;
                    start++;
                }
                if(unique==total)
                    res=Math.max(res,i-start+1);
            }
        }
        return res;

    }
}
// @lc code=end

