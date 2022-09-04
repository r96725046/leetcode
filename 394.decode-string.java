/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    // pre string+cur string
    public String decodeString(String s) {
           Stack<Integer> count=new Stack<Integer>();
        Stack<String> str=new Stack<>();
        int i=0;
        String res="";
        int num=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(c>='0'&&c<='9'){
                num=num*10+(c-'0');
            }else if(c=='['){
                count.push(num);
                num=0;
                str.push(res);
                res="";
            }else if(c==']'){
                int n=count.pop();
                StringBuilder sb=new StringBuilder();
                //Append pre
                sb.append(str.pop());
                for(int j=0;j<n;j++){
                    sb.append(res);
                }
                res=sb.toString();
            }else{
                res+=c;
            }
            i++;
        }
        return res;
    }
}
// @lc code=end

