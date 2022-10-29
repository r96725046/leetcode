/*
 * @lc app=leetcode id=1208 lang=java
 *
 * [1208] Get Equal Substrings Within Budget
 */

// @lc code=start
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int start=0;
        int cost=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            cost+=Math.abs(s.charAt(i)-t.charAt(i));
            while(cost>maxCost)
            {
                cost-=Math.abs(s.charAt(start)-t.charAt(start));
                start++;
            }
            res=Math.max(res,i-start+1);
        }
        return res;
    }
}
// @lc code=end

