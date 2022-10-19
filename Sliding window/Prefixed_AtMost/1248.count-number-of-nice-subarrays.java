/*
 * @lc app=leetcode id=1248 lang=java
 *
 * [1248] Count Number of Nice Subarrays
 */

// @lc code=start
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    public int atMost(int[] nums,int k){
        int odd=0;
        int start=0;
        int res=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1)
                odd++;
            while(odd>k){
                if(nums[start]%2==1)
                    odd--;
                start++;
            }
            res+=i-start+1;
        }
        return res;
    }
}
// @lc code=end

