/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list =new ArrayList<>();
        if(p.length()>s.length())return list;
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<p.length();i++){
            char c=p.charAt(i);
            int v=0;
            if(map.containsKey(c))
                v=map.get(c);
            map.put(c,v+1);
        }

        int count=map.size();
        int l=0;
        int r=0;

        while(r<s.length()){
            char c=s.charAt(r);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                    count--;
            }
            r++;
            while(count==0){


                c=s.charAt(l);
                if(r-l==p.length())
                    list.add(l);
                if(map.containsKey(c))//make string invalid
                {
                    map.put(c,map.get(c)+1);
                    if(map.get(c)>0)
                        count++;
                }
                l++;
            }
        }
        return list;
    }
}
// @lc code=end

