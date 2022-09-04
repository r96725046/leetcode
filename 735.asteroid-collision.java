/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

// @lc code=start
class Solution {
    // 1.v>0
    // 2.v<0
    // 2.1 while abs v > stack.peek &&stack.peek>0
    // 2.2 if v==stack.peek
    // 2.3 if stack is empty or stack.peek<0
    // 2.4 stack.peek > abs v
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int cur:asteroids){
            if(cur>0){
                stack.push(cur);
            }else{
                while(!stack.isEmpty()&&stack.peek()>0&&stack.peek()<Math.abs(cur)){
                    stack.pop();
                }
                if(stack.isEmpty()||stack.peek()<0)
                    stack.push(cur);
                else if(stack.peek()==Math.abs(cur))
                    stack.pop();
                else
                    continue;  
            }
        }
        int[] res=new int[stack.size()];
        for(int i=res.length-1;i>=0;i--)
            res[i]=stack.pop();
        return res;
    }
}
// @lc code=end

