/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    // ***
    // 1.left=-1
    // 2.if char==')' and stack is empty, index=i
    public int longestValidParentheses(String s) {
        int max=0;
        int left=-1;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(i);
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                    if(stack.isEmpty())
                        max=Math.max(max,i-left);
                    else
                        max=Math.max(max,i-stack.peek());
                }else
                    left=i;
            }

        }
        return max;
    }
}
// @lc code=end

