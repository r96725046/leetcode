/*
 * @lc app=leetcode id=747 lang=java
 *
 * [747] Largest Number At Least Twice of Others
 */

// @lc code=start
class Solution {
    public int dominantIndex(int[] nums) {
         if(nums.length==1)return 0;
        int[] arr=new int[101];
        int max=-1;
        int index=-1;
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]=1;
            
            if(nums[i]>max)
            {
                max=nums[i];
                index=i;
            }
        }
        
        for(int i=max-1;i>=0;i--)
            if(arr[i]==1){
                if(i*2<=max)
                    return index;
                else
                    return -1;
            }
        
        return -1;
    }
}
// @lc code=end

