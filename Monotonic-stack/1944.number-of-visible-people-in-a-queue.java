/*
 * @lc app=leetcode id=1944 lang=java
 *
 * [1944] Number of Visible People in a Queue
 */

// @lc code=start
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
                int[] res=new int[heights.length];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<res.length;i++){
            
            while(!stack.isEmpty()&&heights[stack.peek()]<=heights[i]){
                res[stack.pop()]++;
            }
            if(!stack.isEmpty())
                res[stack.peek()]++;
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end

