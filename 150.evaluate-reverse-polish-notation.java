/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        int res=0;
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<tokens.length;i++){
            char c=tokens[i].charAt(tokens[i].length()-1);
            if(c>='0'&&c<='9')
                stack.push(Integer.parseInt(tokens[i]));
            else if(c=='+')
                stack.push(stack.pop()+stack.pop());
            else if(c=='-')
                stack.push(-stack.pop()+stack.pop());
            else if(c=='*')
                stack.push(stack.pop()*stack.pop());
            else{
                int tmp=stack.pop();
                stack.push(stack.pop()/tmp);
            }
        }
        return stack.peek();
    }
}
// @lc code=end

