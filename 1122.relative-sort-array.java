/*
 * @lc app=leetcode id=1122 lang=java
 *
 * [1122] Relative Sort Array
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                int tmp=nums[i];
                nums[i]=nums[index];
                nums[index++]=tmp;
                
            }
        }
        return nums;
    }
}
// @lc code=end

