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
        
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int count=map.size();

        int l=0;
        int r=0;
        int min=Integer.MAX_VALUE;
        String res="";
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
                if(r-l<min){
                    min=r-l;
                    res=s.substring(l,r);
                }
                l++;
            }
           
        }
        return res;
    }
}
// @lc code=end

