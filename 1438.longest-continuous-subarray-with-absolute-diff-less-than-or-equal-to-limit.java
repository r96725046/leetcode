/*
 * @lc app=leetcode id=1438 lang=java
 *
 * [1438] Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max=new LinkedList<>();
        Deque<Integer> min=new LinkedList<>();
        int start=0;
        int res=0;
        for(int i=0;i<nums.length;i++){
            while(!max.isEmpty()&&nums[i]>max.peekLast())
                max.pollLast();
            while(!min.isEmpty()&&nums[i]<min.peekLast())
                min.pollLast();
            max.offer(nums[i]);
            min.offer(nums[i]);
            if(max.peek()-min.peek()>limit)
            {
                if(nums[start]==max.peek())
                    max.poll();
                if(nums[start]==min.peek())
                    min.poll();
                start++;
            }
            res=Math.max(res,i-start+1);
        }
        return res;
    }
}
// @lc code=end

