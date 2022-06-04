/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        
        for(int i=0;i<haystack.length();i++){
            if(needle.length()+i>haystack.length())
                break;
            int k=i;
            for(int j=0;j<needle.length();j++){
                if(haystack.charAt(k)!=needle.charAt(j))
                    break;
                else
                    k++;
                if(j==needle.length()-1)
                    return i;
            }
        }
        return -1;
    }
}
// @lc code=end

