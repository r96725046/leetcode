/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */

// @lc code=start
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        int invalid=0;
        for(int i=0;i<s.length();i++){

            char c=s.charAt(i);
            if(c=='(')
                stack.push(c);
            else{
                if(!stack.isEmpty())
                    stack.pop();
                else
                    invalid++;
            }
        }
        return stack.size()+invalid;
    }
}
// @lc code=end

