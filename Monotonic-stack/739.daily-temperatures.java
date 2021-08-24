/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    // ***
    // https://leetcode.com/tag/monotonic-stack/
    // Descending Monotonic Stack
    // 1.temperatures[i]>temperatures[stack.peek()]
    // 2.push i as index
    // 3.res[index]=i-index;
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[temperatures.length];

        for(int i=0;i<res.length;i++){

            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int index=stack.pop();
                res[index]=i-index;
            }
            stack.push(i);
        }
        return res;

    }
}
// @lc code=end

