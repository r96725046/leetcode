/*
 * @lc app=leetcode id=1673 lang=java
 *
 * [1673] Find the Most Competitive Subsequence
 */

// @lc code=start
class Solution {
    // greedy
    // remain = nums.length-k
    public int[] mostCompetitive(int[] nums, int k) {
        int remain=nums.length-k;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<nums.length;i++){

            while(!stack.isEmpty()&&nums[i]<stack.peek()&&remain>0){
                stack.pop();
                attempt--;
            }
            stack.push(nums[i]);

        }
        int[] res=new int[k];
        int j=0;
        for(int v:stack){
            if(j==k)
                break;
            else{
               res[j]=v;
               j++;
            }
        }
        return res;
    }
}
// @lc code=end

