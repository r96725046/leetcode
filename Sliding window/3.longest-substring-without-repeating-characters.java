/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    // ***
    // 1. index=Math.max(index,map.get(c)+1);
    // 2. i-index+1
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        int index=0;
        int max=1;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c))
                index=Math.max(index,map.get(c)+1);
            map.put(c,i);
            max=Math.max(max,i-index+1);
        }
        return max;
    }
}
// @lc code=end

