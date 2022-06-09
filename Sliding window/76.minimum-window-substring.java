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
        HashMap<Character,Integer> need=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(need.containsKey(c)){
                need.put(c,need.get(c)+1);
            }else{
                need.put(c,1);
            }
        }
        HashMap<Character,Integer> win=new HashMap<>();
        int count=0;
        int len=Integer.MAX_VALUE;
        int start=0;
        String res="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(win.containsKey(c)){
                win.put(c,win.get(c)+1);
            }else{
                win.put(c,1);
            }
            if(need.containsKey(c)&&win.get(c).equals(need.get(c)))
                count++;
            while(count==need.size()){
                if(i-start+1<len){
                    len=i-start+1;
                    res=s.substring(start,i+1);
                }
                c=s.charAt(start);
                if(need.containsKey(c)&&win.get(c).equals(need.get(c)))
                    count--;
                win.put(c,win.get(c)-1);
                start++;
            }
        }
        return res;

    }
}
// @lc code=end

