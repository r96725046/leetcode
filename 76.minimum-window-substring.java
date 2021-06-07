/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    //1. Have a counter or hash-map 
    //2. map.get(c)==0 => counter--;
    //3. if counter==0 l++ =>map++ counter++ 
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return"";
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            int v=0;
            if(map.containsKey(c))
                v=map.get(c);
            map.put(c,v+1);
        }
        int count=map.size();

        int l=0;
        int r=0;
        int len=Integer.MAX_VALUE;
        int head=0;
        while(r<s.length()){

            char c=s.charAt(r);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)count--;
            }
            r++;
            while(count==0){
               
                c=s.charAt(l);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c)>0){
                        count++;      
                    }
                }
                if(r-l<len){
                    len=r-l;
                    head=l;
                }
                l++;
            }
           
        }
        if(len==Integer.MAX_VALUE)
            return "";
        return s.substring(head,head+len);
    }
}
// @lc code=end

