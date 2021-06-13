/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {

    // nums  1  2  3  4
    // res   24 12 4  1 
    // tmp 1 1*1  1*2  2*3 24
    // res   24*1 12*1 4*2 6*1 end
    // 1.nums[i+1]*res[i+1]
    // 2.tmp =1 ,res*=tmp and tmp*=nums[i] for next i
    public int[] productExceptSelf(int[] nums) {
        if(nums.length<2)return nums;
        int[] res=new int[nums.length];
        res[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--)
            res[i]=nums[i+1]*res[i+1];
        int tmp=1;
        for(int i=0;i<nums.length;i++){
            res[i]*=tmp;
            tmp*=nums[i];
        }
        return res;
    }
}
// @lc code=end

