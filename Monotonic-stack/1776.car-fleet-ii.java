/*
 * @lc app=leetcode id=1776 lang=java
 *
 * [1776] Car Fleet II
 */

// @lc code=start
class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        double[] res=new double[cars.length];
        for(int i=0;i<res.length;i++)
            res[i]=-1.0;
        Stack<Integer> stack=new Stack<>();

        for(int i=cars.length-1;i>=0;i--){
            int[] cur= cars[i];
            while(!stack.isEmpty()){
                int[] car=cars[stack.peek()];
                if(car[1]>=cur[1]){
                    stack.pop();
                    continue;
                }
                double time=(double)(car[0]-cur[0])/(cur[1]-car[1]);
                if(time>res[stack.peek()]&&res[stack.peek()]>0){
                    stack.pop();
                    continue;
                }
                break;

            }
            if(!stack.isEmpty())
                res[i]=(double)(cars[stack.peek()][0]-cur[0])/(cur[1]-cars[stack.peek()][1]);
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end

