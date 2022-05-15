/*
 * @lc app=leetcode id=524 lang=java
 *
 * [524] Longest Word in Dictionary through Deleting
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res="";        
        for(String v:dictionary){

            if(isSubSeq(s,v)){
                if(res.length()==v.length()){
                    if(v.compareTo(res)<0)
                        res=v;
                }else if(res.length()<v.length()){
                    res=v;
                }
            }
        }
        return res;

    }
    private boolean isSubSeq(String s,String d){
        int i=0,j=0;
        while(i<s.length()&&j<d.length()){
            if(s.charAt(i)==d.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j==d.length();

    }
}
// @lc code=end

