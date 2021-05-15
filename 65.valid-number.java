/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */

// @lc code=start
class Solution {
    public boolean isNumber(String s) {
        
        int i=0;
        //+ -
        if(s.charAt(i)=='+'||s.charAt(i)=='-')
            i++;

        int pt=0;
        int nums=0;
        //0~9 & . 
        while(i<s.length()){
            char c=s.charAt(i);
            if(c=='.')
                pt++;
            else if(c>='0'&&c<='9')
                nums++;
            else
                break;
            i++;
        }
        if(pt>1||nums==0)
            return false;
        // e,E
        if(i<s.length()){
            char c=s.charAt(i);
            if(c=='E'||c=='e'){
                i++;
                int sign=0;
                nums=0;
                //+ - 0-9
                while(i<s.length()){
                    c=s.charAt(i);
                    if(c=='+'||c=='-')
                    {
                        if(nums>0)return false;
                        sign++;
                    }else if(c>='0'&&c<='9')
                        nums++;
                    else
                        break;
                    i++;
                }
                if(sign>1||nums==0)return false;
            }
        }

        return i==s.length()?true:false;
    }
}
// @lc code=end

