/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    //1. hashmap & 2 direction
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();

        for(int i=0;i<nums.length;i++)
            set.add(nums[i]);
        int max=0;
        for(int i=0;i<nums.length;i++){
           int count=1;
           int c=nums[i]+1;
           while(set.contains(c)){
               set.remove(c);
               count++;
               c++;
               
           }
           int d=nums[i]-1;
           while(set.contains(d)){
               set.remove(d);
               count++;
               d--;
           }
            max=Math.max(max,count);
        }
        return max;
    }
}
// @lc code=end

