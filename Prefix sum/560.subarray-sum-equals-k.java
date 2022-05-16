/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    // case 0
    // Number of times the sum sum-ksum−k has occurred already ++
    public int subarraySum(int[] nums, int k) {
        int[] v=new int[nums.length+1];
        for(int i=1;i<v.length;i++)
            v[i]=v[i-1]+nums[i-1];
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        for(int i=0;i<v.length;i++){

            int n=v[i]-k;
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
