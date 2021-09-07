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
                HashMap<Integer,Integer> map=new HashMap<>();
        int s=0;
        int res=0;
        for(int i=0;i<nums.length;i++){
            
            s+=nums[i];
            if(s-k==0)
                res++;
            if(map.containsKey(s-k))
                res+=map.get(s-k);
           
            if(map.containsKey(s))
                map.put(s,map.get(s)+1);
            else
                map.put(s,1);
        } 
        return res;
    }
}
// @lc code=end
