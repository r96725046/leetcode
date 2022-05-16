/*
 * @lc app=leetcode id=1094 lang=java
 *
 * [1094] Car Pooling
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        TreeMap<Integer,Integer> map=new TreeMap<>();

        for(int[] trip:trips){

            if(!map.containsKey(trip[1]))
                map.put(trip[1],trip[0]);
            else
                map.put(trip[1],map.get(trip[1])+trip[0]);
            if(!map.containsKey(trip[2]))
                map.put(trip[2],-trip[0]);
            else
                map.put(trip[2],map.get(trip[2])-trip[0]);
        }
        int count=0;
        for(int k:map.keySet()){
            count+=map.get(k);
            if(count>capacity)
                return false;
        }
        return true;
    }
}
// @lc code=end

