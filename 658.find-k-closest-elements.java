/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int lo=0;
        int hi=arr.length-1;

        while(hi-lo>=k){
            if(Math.abs(arr[lo]-x)>Math.abs(arr[hi]-x))
                lo++;
            else
                hi--;
        }
        List<Integer> res=new ArrayList<>();
        for(int i=lo;i<=hi;i++)
            res.add(arr[i]);
        return res;
    }
}
// @lc code=end

