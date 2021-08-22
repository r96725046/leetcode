/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start
class Solution {
    // ***
    // 
    // whenever meet a digit which is less than the previous digit, discard the previous one
    // 1.while
    //     while(!stack.isEmpty()&&stack.peek()>c&&k>0)
    // 2.if k > 0 remove stack end
    // 3.remove leading zero
    // 4.if res="" return "0"
    public String removeKdigits(String num, int k) {
    
            Stack<Character> stack=new Stack<>();
            int i=0;
            while(i<num.length()){
                char c=num.charAt(i);
                while(!stack.isEmpty()&&stack.peek()>c&&k>0){
                    stack.pop();
                    k--;
                }
                stack.push(c);
                i++;
            }
            while(k>0){
                stack.pop();
                k--;
            }

            StringBuilder sb =new StringBuilder();
            while(!stack.isEmpty())
                sb.append(stack.pop());
            
            String tmp=sb.toString();
            sb=new StringBuilder();
            for(int j=tmp.length()-1;j>=0;j--){
                if(tmp.charAt(j)=='0'&&sb.length()==0)continue;
                sb.append(tmp.charAt(j));   
            }
            return sb.length()==0?"0":sb.toString();
    }
}
// @lc code=end

