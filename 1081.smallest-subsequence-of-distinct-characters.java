/*
 * @lc app=leetcode id=1081 lang=java
 *
 * [1081] Smallest Subsequence of Distinct Characters
 */

// @lc code=start
class Solution {
    public String smallestSubsequence(String s) {
        int[] count=new int[26];
        boolean[] visited=new boolean[26];
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']+=1;
        }
        for(int i=0;i<s.length();i++){

            char c=s.charAt(i);
            count[c-'a']--;
            if(visited[c-'a'])continue;
            while(!stack.isEmpty()&&stack.peek()>(c-'a')&&count[stack.peek()]>0)
            {
                int index=stack.pop();
                visited[index]=false;
            }
            stack.push(c-'a');
            visited[stack.peek()]=true;
        }
        StringBuilder sb=new StringBuilder();
        for(int i:stack){
            sb.append((char)('a'+i));
        }
        return sb.toString();
    }
}
// @lc code=end

