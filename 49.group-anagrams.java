/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
import java.util.*;
// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<strs.length;i++){

            int[] arr=new int[26];

            for(int j=0;j<strs[i].length();j++){
                int c=strs[i].charAt(j)-'a';
                arr[c]++;
            }
            StringBuilder sb=new StringBuilder();
            for(int k:arr){
                sb.append(k);
                sb.append("#");
            }
            String key=sb.toString();
            if(map.containsKey(key)){
                ArrayList<String> list=map.get(key);
                list.add(strs[i]);
                map.put(key,list);
            }else{
                map.put(key,new ArrayList<String>());
                map.get(key).add(strs[i]);
            }
        }
        for(String key:map.keySet()){
            res.add(map.get(key));
        }
        return res;

    }
}
// @lc code=end

