/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordDict=new HashSet<>(wordList);
        if(!wordDict.contains(endWord))return 0;
        Set<String> set=new HashSet<>();
        set.add(beginWord);
        int dis=1;
        while(!set.contains(endWord)){
            Set<String> next=new HashSet<>();
            for(String word:set){
                char[] chars=word.toCharArray();
                for(int i=0;i<chars.length;i++){
                    for(int j=0;j<26;j++){
                        char tmp=chars[i];
                        chars[i]=(char)('a'+j);
                        String newWord=new String(chars);
                        if(wordDict.contains(newWord)){
                            next.add(newWord);
                            wordDict.remove(newWord);
                        }
                        chars[i]=tmp;
                    }
                }
            }
            dis++;
            if(next.size()==0)return 0;
            set=next;
        }

        return dis;
    }
}
// @lc code=end

