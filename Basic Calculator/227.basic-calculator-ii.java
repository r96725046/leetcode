/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        //1.First 0-9 then +-*/
        Stack<Integer> stack=new Stack<>();
        char sign='+';
        int i=0;
        //use for instead of
        while(i<s.length()){
            char c=s.charAt(i);
            //number is postive so that no need to check 1st sign
           
            if(c>='0'&&c<='9'){
                int tmp=0;
                while(i<s.length()){
                    c=s.charAt(i);
                    if(c>='0'&&c<='9')
                        tmp=tmp*10+(c-'0');
                    else
                        break;
                    i++;
                }
                i--;
                
                if(sign=='+')
                    stack.push(tmp);
                else if (sign=='-')
                    stack.push(-tmp);
                else if(sign=='*')
                    stack.push(stack.pop()*tmp);
                else
                    stack.push(stack.pop()/tmp);
            }else if(c==' '){
                i++;
                continue;
            }else{
                sign=c;
            }
            i++;
        }
        int res=0;
        for(int num:stack)
            res+=num;

        return res;
    }
}
// @lc code=end

