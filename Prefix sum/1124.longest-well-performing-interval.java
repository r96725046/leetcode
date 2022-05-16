/*
 * @lc app=leetcode id=1124 lang=java
 *
 * [1124] Longest Well-Performing Interval
 */

// @lc code=start
class Solution {
    public int longestWPI(int[] hours) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int res=0;
        for(int i=0;i<hours.length;i++){

            sum+=hours[i]>8?1:-1;
            if(sum>0)
                res=i+1;
            else
            {
                if(!map.containsKey(sum))
                    map.put(sum,i);
                if(map.containsKey(sum-1))
                    res=Math.max(res,i-map.get(sum-1));
            }
        }
        return res;
    }
}
// @lc code=end

