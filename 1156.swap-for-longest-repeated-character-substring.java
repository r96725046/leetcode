/*
 * @lc app=leetcode id=1156 lang=java
 *
 * [1156] Swap For Longest Repeated Character Substring
 */

// @lc code=start
class Solution {
    public int maxRepOpt1(String text) {
        int[] freq=new int[26];
        for(int i=0;i<text.length();i++){
            freq[text.charAt(i)-'a']++;
        }
        int res=0;
        for(int i=0;i<26;i++){

            int start=0;
            int count=0;
            for(int j=0;j<text.length();j++){
                if(text.charAt(j)-'a'==i)
                    count++;
                while(j-start+1-count>1){
                    if(text.charAt(start)-'a'==i)
                        count--;
                    start++;
                }
                int cur=0;
                if(j-start+1-count>0&&freq[i]==count)
                    cur=j-start;
                else
                    cur=j-start+1;
                res=Math.max(res,cur);
            }
        }
        return res;
    }
}
// @lc code=end

