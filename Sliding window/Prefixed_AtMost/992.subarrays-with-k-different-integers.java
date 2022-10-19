/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

// @lc code=start
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    public int atMost(int[] nums,int k){

        int[] freq=new int[nums.length+1];
        int start=0;
        int count=0;
        int res=0;
        for(int i=0;i<nums.length;i++){

            if(freq[nums[i]]==0)
                count++;
            freq[nums[i]]++;

            while(count>k){
                freq[nums[start]]--;
                if(freq[nums[start]]==0)
                    count--;
                start++;
            }
            res+=i-start+1;
        }
        return res;
    }
}
// @lc code=end

