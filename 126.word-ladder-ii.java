/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    // 1. for(String w:visited)wordDict.remove(w);
    // 2. String last=path.get(path.size()-1);
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict=new HashSet<>(wordList);
        List<List<String>> res=new ArrayList<>();
        if(!wordDict.contains(endWord))return res;
        Set<List<String>> set=new HashSet<>();
        List<String> list=new ArrayList<>();
        list.add(beginWord);
        set.add(list);
        boolean found=false;
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);
        while(!found &&!set.isEmpty()){
            Set<List<String>> next=new HashSet<>();
            for(String w:visited)
                wordDict.remove(w);
            for(List<String> path:set){
                String last=path.get(path.size()-1);
                char[] chars=last.toCharArray();
                for(int i=0;i<chars.length;i++){
                    for(int j=0;j<26;j++){
                        char tmp=chars[i];
                        chars[i]=(char)('a'+j);
                        String newWord=new String(chars);
                        if(wordDict.contains(newWord)){
                            List<String> newPath=new ArrayList<>(path);
                            newPath.add(newWord);
                            visited.add(newWord);
                            if(newWord.equals(endWord)){
                                res.add(newPath);
                                found=true;
                            }
                            next.add(newPath);
                        }
                        chars[i]=tmp;
                    }
                }
               
            }
            if(next.size()==0)return res;
            set=next;
           
        }
        return res;
    }
}
// @lc code=end

