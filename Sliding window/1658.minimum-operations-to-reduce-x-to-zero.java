/*
 * @lc app=leetcode id=1658 lang=java
 *
 * [1658] Minimum Operations to Reduce X to Zero
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        int target=0;
        for(int v:nums)
            sum+=v;
        if(sum==x)
            return nums.length;
        target=sum-x;
        if(target<0)
            return -1;
        int start=0;
        int res=-1;
        int cur=0;
        for(int i=0;i<nums.length;i++){
            cur+=nums[i];
            while(cur>target){
                cur-=nums[start];
                start++;
            }
            if(cur==target)
                res=Math.max(res,i-start+1);
        }

        return res==-1?-1:nums.length-res;
    }
}
// @lc code=end

