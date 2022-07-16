/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 */

// @lc code=start
class Solution {
    //a multiple of k
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] v=new int[nums.length+1];
        for(int i=1;i<v.length;i++){
            v[i]=v[i-1]+nums[i-1];
        }
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<v.length;i++){
            int n=v[i]%k;
            if(!map.containsKey(n)){
                map.put(n,i);
            }else{
                if(i-map.get(n)>=2)return true;
            }
        }
        return false;
    }
}
// @lc code=end

