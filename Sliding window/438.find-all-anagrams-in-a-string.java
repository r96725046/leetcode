/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] need=new int[26];
        int[] w=new int[26];
        int unique=0;
        for(int i=0;i<p.length();i++){
            if(need[p.charAt(i)-'a']==0)
                unique++;
            need[p.charAt(i)-'a']++;
        }

        List<Integer> res=new ArrayList<>();
        int start=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            w[c-'a']++;
            
            if(need[c-'a']>0&&w[c-'a']==need[c-'a'])
                count++;
            while(count==unique){
                if(i-start+1==p.length())
                    res.add(start);
                c=s.charAt(start);
                if(need[c-'a']>0&&w[c-'a']==need[c-'a'])
                    count--;
                w[c-'a']--;
                start++;
            }
        }
        return res;
    }
}
// @lc code=end

