/*
 * @lc app=leetcode id=771 lang=java
 *
 * [771] Jewels and Stones
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<jewels.length();i++)
        {
            set.add(jewels.charAt(i));
        }
        int res=0;
        for(int i=0;i<stones.length();i++)
        {
            if(set.contains(stones.charAt(i)))
                res++;
        }
        return res; 
    }
}
// @lc code=end

