/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start
class Solution {
    // 1. decreasing monotonic stack for the time to reach target
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars=new int[position.length][2];
        for(int i=0;i<cars.length;i++)
            cars[i]=new int[]{position[i],speed[i]};

        Arrays.sort(cars,(x,y)->Integer.compare(x[0],y[0]));
        Stack<Double> stack=new Stack<>();
        for(int i=0;i<cars.length;i++){
            int[] car=cars[i];
            double sec=(double)(target-car[0])/car[1];
            while(!stack.isEmpty()&&stack.peek()<=sec){
                stack.pop();
            }
            stack.push(sec);
        }
        return stack.size();
    }
}
// @lc code=end

