/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pFreq=new int[26];
        int need=0;
        for(int i=0;i<p.length();i++){
            int c=p.charAt(i)-'a';
            if(pFreq[c]==0)
                need++;
            pFreq[c]++;
        }

        int[] sFreq=new int[26];
        List<Integer> res=new ArrayList<>();
        int start=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';
            sFreq[c]++;
            if(sFreq[c]>0&&sFreq[c]==pFreq[c])
                count++;
            while(count==need){
                if(i-start+1==p.length()){
                    res.add(start);
                }
                c=s.charAt(start)-'a';
                if(sFreq[c]>0&&sFreq[c]==pFreq[c])
                    count--;
                sFreq[c]--;
                start++;
            }
        }
        return res;
    }
}
// @lc code=end

