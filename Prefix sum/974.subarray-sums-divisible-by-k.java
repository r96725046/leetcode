/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] v=new int[nums.length+1];
        for(int i=1;i<v.length;i++){
            v[i]=v[i-1]+nums[i-1];
        }

        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<v.length;i++){
            int n=v[i]%k;
            if(n<0)
                n=(n+k)%k;
            if(!map.containsKey(n))
                map.put(n,1);
            else{
                count+=map.get(n);
                map.put(n,map.get(n)+1);
            }
        }
        return count;
    }
}
// @lc code=end

