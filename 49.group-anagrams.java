/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
import java.util.*;
// @lc code=start
class Solution {
    //1.int[26]
    //2.#concate string
    //1
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();

        HashMap<String,List<String>> map=new HashMap<>();

        for(String str:strs){
            int[] arr=new int[26];

            for(int i=0;i<str.length();i++)
                arr[str.charAt(i)-'a']++;
            StringBuilder sb=new StringBuilder();
            for(int i:arr)
                sb.append(i).append("#");
            String key=sb.toString();
            List<String> group=new ArrayList<>();
            if(map.containsKey(key))
                group=map.get(key);
            else
                group=new ArrayList<>();
            group.add(str);
            map.put(key,group);
        }
        for(String key:map.keySet())
            res.add(map.get(key));

        return res;

    }
}
// @lc code=end

