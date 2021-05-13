import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        
        int sign=1;
        int cur=0;
        int i=0;
        Stack<Integer> stack=new Stack<>();
        while(i<s.length()){
            char c=s.charAt(i);
            if(c=='+'){
                sign=1;
            }else if(c=='-'){
                sign=-1;
            }else if(c>='0'&&c<='9'){
                int tmp=0;   
                while(i<s.length()){
                    c=s.charAt(i);
                    if(c>='0'&&c<='9'){
                        tmp=tmp*10+(c-'0');
                        i++;
                    }else
                        break;
                }
                i--;
                cur=cur+sign*tmp;
            }else if(c=='('){
                stack.push(cur);
                stack.push(sign);
                sign=1;
                cur=0;
            }else if(c==')'){
                //sign is for current value;
                cur=cur*stack.pop()+stack.pop();
            }
            i++;
        }

        return cur;
    }
}
// @lc code=end

