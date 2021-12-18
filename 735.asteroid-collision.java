/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<asteroids.length;i++){
            if(stack.isEmpty())
                stack.push(asteroids[i]);
            else{
                int top=asteroids[i];
                //if 1
                while(!stack.isEmpty()&&stack.peek()>0&&top<0){
                    int diff=stack.peek()-Math.abs(top);
                    if(diff<0)
                        stack.pop();
                    else
                        break;
                }
                // if 2
                if(stack.isEmpty()||stack.peek()<0||top>0)stack.push(top);
                // if 3
                else  if(stack.peek()+top==0)stack.pop();

            }
        }
        int[] res=new int[stack.size()];
        for(int i=res.length-1;i>=0;i--)
            res[i]=stack.pop();

        return res;
    }
}
// @lc code=end

