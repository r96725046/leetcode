/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int v=Math.abs(nums[i]);
            nums[v-1]=-Math.abs(nums[v-1]);
            
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                list.add(i+1);
        }
        return list;
    }
}
// @lc code=end

