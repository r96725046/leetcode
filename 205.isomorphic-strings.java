/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(t.charAt(i)))
            {
                if(map.get(t.charAt(i))!=s.charAt(i))
                    return false;
            }else{
                if(set.contains(s.charAt(i)))
                    return false;
                map.put(t.charAt(i),s.charAt(i));
                set.add(s.charAt(i));
            }  
        }
        return true; 
    }
}
// @lc code=end

