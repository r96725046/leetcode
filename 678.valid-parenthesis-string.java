/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
 Stack<Integer> stack=new Stack<>();
        Stack<Integer> wildcard=new Stack<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(')stack.push(i);
            else if(c==')'){
                if(stack.isEmpty()){
                    if(wildcard.isEmpty())
                        return false;
                    else 
                        wildcard.pop();
                }else{
                    stack.pop();
                }  
            }else{
                wildcard.push(i);
            }
        }
        while(!stack.isEmpty()&&!wildcard.isEmpty()){
            if(stack.peek()<wildcard.peek()){
                stack.pop();
                wildcard.pop();
            }else
                break;
        }

        return stack.isEmpty();
    }
}
// @lc code=end

