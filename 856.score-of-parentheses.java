/*
 * @lc app=leetcode id=856 lang=java
 *
 * [856] Score of Parentheses
 */

// @lc code=start
class Solution {
    //  while(stack.peek()!=-1)
    //      cur+=stack.pop();
    //  cur*=2
    // pop -1 and push cur
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
       
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(')
            {
                stack.push(-1);
            }else{   
                int cur=0;                 
                if(stack.peek()!=-1){
                    while(stack.peek()!=-1)
                        cur+=stack.pop();
                    cur=cur*2;
                }else{
                    cur+=1;         
                }
                stack.pop();
                stack.push(cur);
            }
        }
        int res=0;
        for(int v:stack){
            res+=v;
        }
        return res;
    }
}
// @lc code=end

