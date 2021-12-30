/*
 * @lc app=leetcode id=890 lang=java
 *
 * [890] Find and Replace Pattern
 */

// @lc code=start
class Solution {
    //1. w[word.charAt(i)-'a']!=p[pattern.charAt(i)-'a']
    //2. last pos 
    //   p[pattern.charAt(i)-'a']=i+1;
    //   w[word.charAt(i)-'a']=i+1;
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res=new ArrayList<>();
       
        for(int j=0;j<words.length;j++){
            String word=words[j];
            int[] w=new int[26];
            int[] p=new int[26];
            boolean same=true;
            for(int i=0;i<word.length();i++){
                if(w[word.charAt(i)-'a']!=p[pattern.charAt(i)-'a']){
                    same=false;
                    break;
                }else{
                    p[pattern.charAt(i)-'a']=i+1;
                    w[word.charAt(i)-'a']=i+1;
                }
            }
            if(same)
                res.add(word);
        }
        return res;
    }
}
// @lc code=end

