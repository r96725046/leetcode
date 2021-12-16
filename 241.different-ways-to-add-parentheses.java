/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res=new ArrayList<>();

        if(expression.length()==1){
            res.add(Integer.valueOf(expression));
            return res;
        }
        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                String part1=expression.substring(0,i);
                String part2=expression.substring(i+1);
                List<Integer> l1=diffWaysToCompute(part1);
                List<Integer> l2=diffWaysToCompute(part2);
             
                for(int v1:l1){
                    for(int v2:l2){
                        int n=0;
                        if(c=='+')
                            n=v1+v2;
                        else if(c=='-')
                            n=v1-v2;
                        else if(c=='*')
                            n=v1*v2;
                        res.add(n);
                    }
                }
            }
        }
        if(res.size()==0)
            res.add(Integer.valueOf(expression));
        return res;
    }
}
// @lc code=end

