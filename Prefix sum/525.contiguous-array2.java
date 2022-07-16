/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        int[] sum=new int[nums.length];
        int pre=0;
        for(int i=0;i<nums.length;i++){
            int cur=nums[i]==0?-1:nums[i];
            sum[i]=pre+cur;
            pre=sum[i];
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int max=0;
        for(int i=0;i<sum.length;i++){
            int val=sum[i];
            if(!map.containsKey(val)){
                map.put(val,i);
            }else{
                max=Math.max(max,i-map.get(val));
            }
        }
        return max;
    }
}
// @lc code=end

