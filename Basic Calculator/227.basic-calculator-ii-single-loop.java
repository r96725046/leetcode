/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        s+='+';
        int i=0;
        char sign='+';
        int num=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(c==' '){
                i++;
                continue;
            }
            if(c>='0'&&c<='9'){
                num=num*10+(c-'0');
            }else{
                if(sign=='+'){
                    stack.push(num);
                }else if(sign=='-'){
                    stack.push(-num);
                }else if(sign=='*'){
                    stack.push(stack.pop()*num);
                }else{
                    stack.push(stack.pop()/num);
                }
                num=0;
                sign=c;
            }
            i++;
        }
        int res=0;
        for(int v:stack)
           res+=v;
        return res;
    }
}
// @lc code=end

