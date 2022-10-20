/*
 * @lc app=leetcode id=1456 lang=java
 *
 * [1456] Maximum Number of Vowels in a Substring of Given Length
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        

        int start=0;
        int max=0;
        int freq=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(isVowel(c))
                freq++;
            if(i-start+1>k){
                if(isVowel(s.charAt(start)))
                    freq--;
                start++;
            }
            max=Math.max(max,freq);
        }
        return max;
    }
    public boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
// @lc code=end

