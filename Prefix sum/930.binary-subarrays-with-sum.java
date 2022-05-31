/*
 * @lc app=leetcode id=930 lang=java
 *
 * [930] Binary Subarrays With Sum
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] v=new int[nums.length+1];

        for(int i=1;i<v.length;i++){
            v[i]=v[i-1]+nums[i-1];
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        for(int i=0;i<v.length;i++){
            int n=v[i]-goal;
            if(map.containsKey(n)){
                res+=map.get(n);
            }
            if(!map.containsKey(v[i])){
                map.put(v[i],1);
            }else{
                map.put(v[i],map.get(v[i])+1);
            }
        }
        return res;
    }
}
// @lc code=end

