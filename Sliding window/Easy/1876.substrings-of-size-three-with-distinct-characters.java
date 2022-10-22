/*
 * @lc app=leetcode id=1876 lang=java
 *
 * [1876] Substrings of Size Three with Distinct Characters
 */

// @lc code=start
class Solution {
    public int countGoodSubstrings(String s) {
        
        int[] freq=new int[26];
        int count=0;
        int res=0;
        for(int i=0;i<s.length();i++){

            int c=s.charAt(i)-'a';
            if(freq[c]==0)
                count++;
            freq[c]++;
            if(count==3)
                res++;
            if(i>=2){
                freq[s.charAt(i-2)-'a']--;
                if(freq[s.charAt(i-2)-'a']==0)
                    count--;
            }
        }
        return res;
    }
}
// @lc code=end

