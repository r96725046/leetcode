/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    //1. hashmap & 2 direction because it must have a solution at least 1;
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();

        for(int n:nums)
            set.add(n);
        int max=0;
        for(int n:nums){

            int pre=n-1;
            int next=n+1;
            int count=1;
            while(set.contains(pre))
            {
                count++;
                set.remove(pre);
                pre--;
            }
            while(set.contains(next))
            {
                count++;
                set.remove(next);
                next++;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
// @lc code=end

