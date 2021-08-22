/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    // pre string+cur string
    public String decodeString(String s) {
        Stack<Integer> countStack=new Stack<>();
        Stack<String>  resStack=new Stack<>();
        int i=0;
        String res="";
       
        while(i<s.length()){

            char c=s.charAt(i);
            if(c>='0' && c<='9'){
                int tmp=0;
                while(i<s.length()){
                    c=s.charAt(i);
                    if(c>='0'&&c<='9')
                        tmp=tmp*10+(c-'0');
                    else
                        break;
                    i++;
                }
                i--;
                countStack.push(tmp);
            }else if(c=='['){
                resStack.push(res);
                res="";
            }else if(c==']'){
                int count=countStack.pop();
                StringBuilder sb=new StringBuilder();
                sb.append(resStack.pop());
                for(int j=0;j<count;j++)
                    sb.append(res);
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

