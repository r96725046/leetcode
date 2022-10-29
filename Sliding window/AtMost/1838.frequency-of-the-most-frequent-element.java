/*
 * @lc app=leetcode id=1838 lang=java
 *
 * [1838] Frequency of the Most Frequent Element
 */

// @lc code=start
class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        int start=0;
        int sum=0;
        int res=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(nums[i]*(i-start+1)-sum>k){
                sum-=nums[start];
                start++;
            }
            res=Math.max(res,i-start+1);
        }
        return res;

    }
}
// @lc code=end

