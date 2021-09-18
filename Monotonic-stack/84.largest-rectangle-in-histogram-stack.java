/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    //1.count pre area
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int res=0;
        stack.push(-1);
        for(int i=0;i<heights.length;i++){    
            while(stack.peek()!=-1&&heights[stack.peek()]>heights[i]){
                int pre=stack.pop();
                res=Math.max(res, heights[pre]*(i-1-stack.peek()));
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int pre=stack.pop();
            res=Math.max(res,heights[pre]*(heights.length-1-stack.peek()));
        }
        return res;
    }
}
// @lc code=end
