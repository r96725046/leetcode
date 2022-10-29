/*
 * @lc app=leetcode id=1234 lang=java
 *
 * [1234] Replace the Substring for Balanced String
 */

// @lc code=start
class Solution {
    public int balancedString(String s) {
        
        int[] count=new int[128];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
        int d=s.length()/4;
        int start=0;
        int res=s.length();
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)]--;
            while(start<s.length()&&count['Q']<=d&&count['W']<=d
                &&count['E']<=d&&count['R']<=d){
                    res=Math.min(res,i-start+1);
                    count[s.charAt(start)]++;
                    start++;
            }
           
        }

        return res;
    }
}
// @lc code=end

