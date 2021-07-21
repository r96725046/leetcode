/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='{'||c=='['||c=='(')
                stack.push(c);
            else{
                if(stack.isEmpty())return false;
                char p=stack.peek();
                if(c=='}'&&p!='{')return false;
                if(c==')'&&p!='(')return false;
                if(c==']'&&p!='[')return false;
                stack.pop();
            }
        }
        return stack.isEmpty();

    }
}
// @lc code=end

