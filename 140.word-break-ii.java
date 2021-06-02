/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    // ***
    // 1.startsWith
    // 2.tmp string
    // 3.cache***
    // 1
    HashMap<String,List<String>> map=new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s,wordDict);
    }
    public List<String> dfs(String s,List<String> wordDict){
        if(map.containsKey(s))
            return map.get(s);
     
        List<String> list=new ArrayList<>();
        if(0==s.length()){
            list.add("");
            return list;
        }
        for(String word:wordDict){
            if(s.startsWith(word)){
                List<String> sub=dfs(s.substring(word.length()),wordDict);
                for(String str:sub)
                {
                    if(str.length()>0)
                        str=" "+str;
                    list.add(word+str);
                }
            }
        }
        map.put(s,list);
        return list;
    }
}
// @lc code=end

