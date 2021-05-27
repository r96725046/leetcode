/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
         HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int k=nums1[i]+nums2[j];
                if(map.containsKey(k))
                {
                    int tmp=map.get(k);
                    map.put(k,tmp+1);
                }else
                    map.put(k,1);
            }
        }
        int count=0;
        int[] list2=new int[nums3.length+nums4.length];
        int d=0;
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                int k=nums3[i]+nums4[j];
                if(map.containsKey(-k))
                    count+=map.get(-k);
                
            }
            
        }
      
        return count;
    }
}
// @lc code=end

