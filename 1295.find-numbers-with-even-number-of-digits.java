/*
 * @lc app=leetcode id=1295 lang=java
 *
 * [1295] Find Numbers with Even Number of Digits
 */

// @lc code=start
class Solution {
    public int findNumbers(int[] nums) {
         int c=0;
        for(int i=0;i<nums.length;i++){
            
            int n=nums[i];
            int l=0;
            while(n!=0){
                n/=10;
                l++;
            }
            if(l%2==0)c++;
            
        }
        return c;
    }
}
// @lc code=end

