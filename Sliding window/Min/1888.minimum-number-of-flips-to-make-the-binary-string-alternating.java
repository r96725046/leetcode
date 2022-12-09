/*
 * @lc app=leetcode id=1888 lang=java
 *
 * [1888] Minimum Number of Flips to Make the Binary String Alternating
 */

// @lc code=start
class Solution {
    public int minFlips(String s) {
        
        String str=s+s;

        int s0=0;
        int s1=0;
        int len=s.length();
        int res=s.length();
      
        int cnt1=0;
        int cnt2=0;
        for(int i=0;i<str.length();i++){
            s0=i%2==0?0:1;
            s1=i%2==0?1:0;
            int c=str.charAt(i)-'0';
            if(c!=s0)
                cnt1++;
            if(c!=s1)
                cnt2++;
            if(i>=len-1){
                if(i>=len){
                    c=str.charAt(i-len)-'0';
                    s0=(i-len)%2==0?0:1;
                    s1=(i-len)%2==0?1:0;
                    if(c!=s0)
                        cnt1--;
                    if(c!=s1)
                        cnt2--;
                }
                res=Math.min(res,Math.min(cnt1,cnt2));
            }
        }
        return res;

    }
}
// @lc code=end

