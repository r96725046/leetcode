/*
 * @lc app=leetcode id=1130 lang=java
 *
 * [1130] Minimum Cost Tree From Leaf Values
 */

// @lc code=start
class Solution {
    //https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/476513/Java-Mono-Stack-98-Example-to-explain
    // res+=tmp*Math.min(stack.peek(),v);
    // move the bigger node to different subtree
    public int mctFromLeafValues(int[] arr) {
        
        int res=0;

        Stack<Integer> stack=new Stack<>();
        for(int v:arr){
            while(!stack.isEmpty()&&v>stack.peek()){
                int tmp=stack.pop();

                if(stack.isEmpty()){
                    res+=tmp*v;
                }else{
                    res+=tmp*Math.min(stack.peek(),v);
                }
            }
            stack.push(v);
        }
        while(stack.size()>1)
            res+=stack.pop()*stack.peek();
        
        return res;
    }
}
// @lc code=end

