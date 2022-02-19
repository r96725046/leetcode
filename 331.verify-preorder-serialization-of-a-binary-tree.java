/*
 * @lc app=leetcode id=331 lang=java
 *
 * [331] Verify Preorder Serialization of a Binary Tree
 */

// @lc code=start
class Solution {
    // using a stack, scan left to right
    // case 1: we see a number, just push it to the stack
    // case 2: we see #, check if the top of stack is also #
    // if so, pop #, pop the number in a while loop, until top of stack is not #
    // if not, push it to stack
    // in the end, check if stack size is 1, and stack top is #
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack=new Stack<>();
        String[] arr=preorder.split(",");
        if(preorder==null||preorder.length()==0)return false;
        for(String s:arr){
            while(!stack.isEmpty()&&s.equals("#")&&stack.peek().equals("#")){
                stack.pop();
                if(stack.isEmpty())return false;
                stack.pop();
            }
            stack.push(s);
        }

        return stack.size()==1&&stack.peek().equals("#");
    }
}
// @lc code=end

