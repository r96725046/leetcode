/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        // ***
        //1.space 
        //2.+-
        //3."long digit"

        if(s.length()==0)return 0;
        int i=0;
        int sign=1;
        while(i<s.length()&&s.charAt(i)==' ')i++;

        if(i<s.length()){
            if(s.charAt(i)=='-'||s.charAt(i)=='+')
            {
                if(s.charAt(i)=='-')sign=-1;
                i++;
            }
        }
        long res=0;
        while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){

            res=res*10+(s.charAt(i)-'0');
            
            if(res*sign>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(res*sign<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            i++;
        }
        return (int)res*sign;

    }
}
// @lc code=end

