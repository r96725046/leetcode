/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    // **
    // 1
    HashMap<String,Boolean> map=new HashMap<>();
    HashSet<String> dict=new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str:wordDict)
            dict.add(str);
        return canBreak(s,dict);

    }
    private boolean canBreak(String s, HashSet<String> dict){
        if(map.containsKey(s))
            return map.get(s);
        if(dict.contains(s)){
            map.put(s,true);
            return;
        }
        
        map.put(s,false);
        for(int i=0;i<s.length();i++){
            String sub=s.substring(0,i+1);
            if(dict.contains(sub)&&canBreak(s.substring(i+1,s.length()),dict)){
                map.put(s,true);
            }
        }    
        return map.get(s);
    }
}
// @lc code=end

