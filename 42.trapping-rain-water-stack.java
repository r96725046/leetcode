/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack=new Stack<>();

        int i=0;
        int res=0;
        while(i<height.length){
            while(!stack.isEmpty()&&height[stack.peek()]<height[i]){
                int pre=stack.pop();
                
                if(stack.isEmpty())break;
                
                int min=Math.min(height[stack.peek()],height[i]);
                // 1 3 trap length = 1
                res+=(i-stack.peek()-1)*(min-height[pre]);
            }
            stack.push(i);
            i++;
        }
        return res;

    }
}
// @lc code=end

