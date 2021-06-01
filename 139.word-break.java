/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    // **
    // 1
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(s==null||s.length()==0)
            return false;

        boolean[] dp=new boolean[s.length()];
        
        for(int i=0;i<s.length();i++){
            // j -> i
            for(int j=0;j<=i;j++){
                String sub=s.substring(j,i+1);
                //leetcode
                //..etcode
                //...code check && previous word j-1==true 
                if(wordDict.contains(sub)&&(j==0||dp[j-1]))
                {
                    dp[i]=true;
                    break;
                }

            }



        }
        return dp[s.length()-1];

    }
}
// @lc code=end

