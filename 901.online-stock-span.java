/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */

// @lc code=start
class StockSpanner {
    // 1.less or equal
    // 2.int[]
    Stack<int[]> stack;
    public StockSpanner() {
        stack=new Stack<>();
    }
    
    public int next(int price) {
        int span=1;

        while(!stack.isEmpty()&&price>=stack.peek()[0])
        {
                int[] top=stack.pop();
                span+=top[1];
        }
        stack.push(new int[]{price,span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

