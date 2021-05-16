/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){

            if(nums[i]==i+1||nums[i]<=0||nums[i]>nums.length){
                i++;
            }else{


                int tmp=nums[i];
                if(nums[i]!=nums[tmp-1])
                {
                    nums[i]=nums[tmp-1];
                    nums[tmp-1]=tmp;
                }else
                    i++;
            }

        }
        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]!=j+1)
                return j+1;
        }
        return nums.length+1;
    }
}
// @lc code=end

