/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    // *
    // 1.hashset
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res=new HashSet<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){

            int l=i+1;
            int r=nums.length-1;
            while(l<r){

                if(nums[i]+nums[l]+nums[r]==0)
                {
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    l++;
                    r--;
                }else if(nums[i]+nums[l]+nums[r]>0)
                    r--;
                else
                    l++;
            }
           

        }
        return new ArrayList<List<Integer>>(res);
    }
}
// @lc code=end

