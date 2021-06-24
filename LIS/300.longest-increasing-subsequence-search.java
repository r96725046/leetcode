/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    // ***
    // 1. "int[] res"
    // 2. if nums[i]>res[index] index++ put nums[i] to res[index]
    // 3. else binary search 0~i-1 find a index for "nums[i]"
    // 4. return index+1
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)return 0;
        int[] res=new int[nums.length];

        res[0]=nums[0];
        int index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>res[index]){
                index++;
                res[index]=nums[i];
            }else{
                int pos=search(res,0,index,nums[i]);
                res[pos]=nums[i];
            }
        }
        return index+1;
    }
    private int search(int[] res,int l,int r,int target){

        while(l<=r){

            int mid=l+(r-l)/2;
            if(res[mid]==target)
                return mid;
            else if(res[mid]>target)
                r=mid-1;
            else
                l=mid+1;       
        }
        return l;
    }
}
// @lc code=end

