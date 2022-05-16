/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        int[] v=new int[nums.length+1];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<v.length;i++){
            int n=nums[i-1]==0?-1:nums[i-1];
            v[i]=v[i-1]+n;
        }
        int res=0;

        for(int i=0;i<v.length;i++){
            if(!map.containsKey(v[i])){
                map.put(v[i],i);
            }else{
                res=Math.max(res,i-map.get(v[i]));
            }
        }
        return res;
    }
}
// @lc code=end

