/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
   
    HashMap<String,Integer> map=new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==0)return 0;
       
        int res=dfs(nums,0,0,target);
        return res;
    }
    public int dfs(int[] nums,int index,int cur,int target){

        if(index==nums.length){
            if(cur==target){
                return 1;
            }else
                return 0;
        }
        String key=index+"#"+cur;
        if(map.containsKey(key))
            return map.get(key);

       
        int add=dfs(nums,index+1,cur+nums[index],target);
        int minus=dfs(nums,index+1,cur-nums[index],target);
        map.put(index+"#"+cur,add+minus);
        return add+minus;
    }
   
}
// @lc code=end

