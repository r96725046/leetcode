/*
 * @lc app=leetcode id=1208 lang=java
 *
 * [1208] Get Equal Substrings Within Budget
 */

// @lc code=start
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i=0,j=0;
        int sum=0;
        int max=0;
        while(j<t.length()){
            sum+=Math.abs(s.charAt(j)-t.charAt(j));
            while(sum>maxCost){
                sum-=Math.abs(s.charAt(i)-t.charAt(i));
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
// @lc code=end

