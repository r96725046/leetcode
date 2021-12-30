/*
 * @lc app=leetcode id=916 lang=java
 *
 * [916] Word Subsets
 */

// @lc code=start
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res=new ArrayList<>();
        int[] w=new int[26];
        for(int i=0;i<words2.length;i++){
            int[] c=count(words2[i]);
            for(int j=0;j<26;j++){
                w[j]=Math.max(c[j],w[j]);
            }
        }
        for(int i=0;i<words1.length;i++){
            String word=words1[i];
            int[] c=count(word);
            boolean match=true;
            for(int j=0;j<26;j++){
                if(c[j]<w[j]){
                    match=false;
                    break;
                }
            }
            if(match)
                res.add(word);
        }
        return res;
    }
    public int[] count(String word){
        int[] c=new int[26];
        for(int i=0;i<word.length();i++)
            c[word.charAt(i)-'a']++;
        return c;
    }
}
// @lc code=end

