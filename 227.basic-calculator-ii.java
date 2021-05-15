/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        
        Stack<Integer> stack=new Stack<>();
        int sum=0;
        char sign='+';
        int i=0;
        //use for instead of
        while(i<s.length()){
            char c=s.charAt(i);
            //number is postive so that no need to check 1st sign
            //First 0-9 then +-*/
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
                sum+=tmp;
                
                if(sign=='+')
                    stack.push(sum);
                else if (sign=='-')
                    stack.push(-sum);
                else if(sign=='*')
                    stack.push(stack.pop()*sum);
                else if(sign=='/')
                    stack.push(stack.pop()/sum);
                sum=0;
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

