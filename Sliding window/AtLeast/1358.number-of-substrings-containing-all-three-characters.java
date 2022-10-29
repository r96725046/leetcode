/*
 * @lc app=leetcode id=1358 lang=java
 *
 * [1358] Number of Substrings Containing All Three Characters
 */

// @lc code=start
class Solution {
    public int numberOfSubstrings(String s) {
        
        int[] freq=new int[3];
        int start=0;
        int res=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==0)
                count++;
            freq[s.charAt(i)-'a']++;
            while(count==3){
                res+=s.length()-i;
                freq[s.charAt(start)-'a']--;
                if(freq[s.charAt(start)-'a']==0)
                    count--;
                start++;
            }
        }
        return res;
    }
}
// @lc code=end

