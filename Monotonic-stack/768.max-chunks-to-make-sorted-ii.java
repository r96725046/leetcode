/*
 * @lc app=leetcode id=768 lang=java
 *
 * [768] Max Chunks To Make Sorted II
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
       Stack<Integer> stack=new Stack<>();
       stack.push(arr[0]);

       for(int i=1;i<arr.length;i++){
            if(arr[i]>=stack.peek())
                stack.push(arr[i]);
            else{
                int tmp=stack.peek();
                while(!stack.isEmpty()&&stack.peek()>arr[i])
                    stack.pop();
                stack.push(tmp);
            }
       } 
       return stack.size();
    }
}
// @lc code=end

