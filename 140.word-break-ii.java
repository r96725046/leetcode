/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    // ***
    // 1.String.start"s"With()
    // 2.tmp string
    // 3.cache***
    // 4.s.length()==0 list.add("")
    // 1
    HashMap<String,List<String>> map=new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
       return dfs(s,wordDict);
    }
    private List<String> dfs(String s,List<String> wordDict){
        if(map.containsKey(s))return map.get(s);
        List<String> list=new ArrayList<String>();
        if(s.length()==0){
            list.add("");
            return list;
        }
        for(String word:wordDict){
            if(s.startsWith(word)){
                List<String> sub=dfs(s.substring(word.length()),wordDict);
                for(String str:sub){
                    if(str.length()>0)
                        list.add(word+" "+str);
                    else
                        list.add(word);
                }   
            }
        }
        map.put(s,list);
        return list;
    }
}
// @lc code=end

