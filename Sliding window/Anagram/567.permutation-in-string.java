/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }
        int count=0;
        int start=0;
        HashMap<Character,Integer> window=new HashMap<>();
        for(int i=0;i<s2.length();i++){
            char c=s2.charAt(i);
            if(map.containsKey(c))
            {
                if(window.containsKey(c))
                    window.put(c,window.get(c)+1);
                else
                    window.put(c,1);
                if(map.get(c).equals(window.get(c)))
                    count++;
            }
            while(count==map.size()){
                
                if(i-start+1==s1.length())
                    return true;
                c=s2.charAt(start);
                if(map.containsKey(c)){     
                    window.put(c,window.get(c)-1);
                    if(window.get(c).equals(map.get(c)-1))
                        count--;
                }
                start++;
            }
        }
        return false;
    }
}
// @lc code=end

