/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 */

// @lc code=start
class Solution {
    int[] arr;
    int[] nums;
    Random r;
    public Solution(int[] nums) {
        arr=new int[nums.length];
        this.nums=nums;
        r=new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for(int i=0;i<nums.length;i++)
            arr[i]=nums[i];
        return arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=arr.length-1;i>=0;i--){
            int pos=r.nextInt(i+1);
            swap(arr,i,pos);
        }
        return arr;
    }
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

