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
    // 2
    HashMap<String,List<String>> map=new HashMap<>(); 
    HashSet<String> set=new HashSet<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
       for(String str:wordDict)
            set.add(str);
       return dfs(s);
    }
    private List<String> dfs(String s){
        if(map.containsKey(s))
            return map.get(s);
        List<String> cur=new ArrayList<>();
        if(s.length()==0){
            cur.add(s);
            return cur;
        }
        for(int i=0;i<s.length();i++){
            String sub=s.substring(0,i+1);
            if(set.contains(sub)){
                List<String> list=dfs(s.substring(i+1,s.length()));
                for(String str:list){
                    if(str.length()==0)
                        cur.add(sub);
                    else
                        cur.add(sub+" "+ str);
                }  
            }   
        }
        map.put(s,cur);
        return map.get(s);
    }
}
// @lc code=end

