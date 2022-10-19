/*
 * @lc app=leetcode id=1839 lang=java
 *
 * [1839] Longest Substring Of All Vowels in Order
 */

// @lc code=start
class Solution {
    public int longestBeautifulSubstring(String word) {
        int start=0;
        int max=-1;
        int count=0;
        int res=0;
        for(int i=0;i<word.length();i++){
            int c=word.charAt(i)-'a';
            if(c>=max)
            {
                if(c>max)
                    count++;
                max=c;
            }else
            {
                max=c;
                start=i;
                count=1;
            }
            if(count==5)
                res=Math.max(res,i-start+1);
        }
        return res;
    }
}
// @lc code=end

