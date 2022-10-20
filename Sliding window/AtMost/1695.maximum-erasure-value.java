/*
 * @lc app=leetcode id=1695 lang=java
 *
 * [1695] Maximum Erasure Value
 */

// @lc code=start
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max=0;
        int sum=0;
        int start=0;
        int[] freq=new int[10001];

        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
            sum+=nums[i];
            while(freq[nums[i]]>1){
                freq[nums[start]]--;
                sum-=nums[start];
                start++;
            }
            max=Math.max(max,sum);
        }

        return max;
    }
}
// @lc code=end

