/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    //1. p=end index=i=start
    //2. move items >p to left
    //3. swap index and p
    public int findKthLargest(int[] nums, int k) {
        return partition(nums,0,nums.length-1,k);
    }
    private int partition(int[] nums,int l,int r,int k){
        int p=nums[r];
        int index=l;

        for(int i=l;i<r;i++){
            if(nums[i]>p)
            {
                swap(nums,i,index);
                index++;
            }
        }
        swap(nums,index,r);
        if(index==k-1)
            return nums[index];
        else if(index>k-1)
            return partition(nums,l,index-1,k);
        else
            return partition(nums,index+1,r,k);
           
    }
    private void swap(int[] nums,int i,int j)
    {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
// @lc code=end

