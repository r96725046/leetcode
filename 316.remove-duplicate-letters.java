/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
    // ****
    //https://leetcode.com/problems/remove-duplicate-letters/discuss/76762/Java-O(n)-solution-using-stack-with-detail-explanation
    // O(MN) time: M is size of alphabet, like O(26*N) for this problem.
    // pre: stack holding previous char
    // post: how many char left after cur position
    // dup: if char is already on stack (in result)
    // 1.count
    // 2.1 visited i++ continue
    // 2.2 while(!stack.isEmpty()&&count[stack.peek()-'a']>0&&c<stack.peek())
    public String removeDuplicateLetters(String s) {
        int[] count=new int[26];
        boolean[] visited=new boolean[26];

        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']++;

        int i=0;
        while(i<s.length()){
           
            char c=s.charAt(i);
            count[c-'a']--;
            if(visited[c-'a']){
                i++;
                continue;
            }
            while(!stack.isEmpty()&&count[stack.peek()-'a']>0&&c<stack.peek()){
                visited[stack.peek()-'a']=false;
                stack.pop();
            }
            stack.push(c);
            visited[c-'a']=true;
            i++;
        }
        StringBuilder sb=new StringBuilder();
        for(char c:stack)
            sb.append(c);
        return sb.toString();
    }
}
// @lc code=end

