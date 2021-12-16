/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int v=Math.abs(nums[i]);
            if(nums[v-1]<0)
                list.add(v);
            else
                nums[v-1]*=-1;
        }
        return list;
    }
}
// @lc code=end

