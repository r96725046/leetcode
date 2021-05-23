/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    List<String> res =new ArrayList<String>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        dfs(s,wordDict,"");
        return res;
    }
    public void dfs(String s,List<String> wordDict, String cur){
        if(0==s.length()){
            res.add(cur);
            return;
        }
        //startsWith
        for(String word:wordDict){
            if(s.startsWith(word)){
                String tmp="";
                if(cur.length()==0)
                    tmp=word;
                else
                    tmp=cur+ " " + word;
                dfs(s.substring(word.length()),wordDict,tmp);
            }
        }
    }
}
// @lc code=end

