/*
 * @lc app=leetcode id=1475 lang=java
 *
 * [1475] Final Prices With a Special Discount in a Shop
 */

// @lc code=start
class Solution {
    public int[] finalPrices(int[] prices) {
        int[] res=new int[prices.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<prices.length;i++){
            res[i]=prices[i];
            while(!stack.isEmpty()&&prices[stack.peek()]>=prices[i]){
                res[stack.pop()]-=prices[i];
            }
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end

