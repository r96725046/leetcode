/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS=new Stack<>();
        Stack<Character> stackT=new Stack();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='#'){
                if(!stackS.isEmpty())
                   stackS.pop();
            }else
                stackS.push(c);
        }
        
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(c=='#'){
                if(!stackT.isEmpty())
                    stackT.pop();
            }else
                stackT.push(c);
        }
        while(!stackS.isEmpty()&&!stackT.isEmpty()){
            if(stackS.pop()!=stackT.pop())
                return false;
        }
        return stackS.size()==stackT.size();
    }
}
// @lc code=end

