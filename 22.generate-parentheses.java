/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n,"",0,0);
        return res;
    }
    private void backtrack(int n, String s,int left,int right){

        if(left==n&&right==n){
            res.add(s);
            return;
        }
        if(left<n)
            backtrack(n,s+"(",left+1,right);
        if(right<n&&right<left)
            backtrack(n,s+")",left,right+1);

    }
}
// @lc code=end

