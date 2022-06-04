/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
    HashSet<Integer> set=new HashSet<>();
    boolean[] seen;
    boolean res=false;
    public boolean canPartition(int[] nums) {
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        if(sum%2!=0)return false;
        seen=new boolean[nums.length];
        dfs(nums,0,seen);
        return res;
        
    }
    public void dfs(int[] nums,int cur, boolean[] seen){
        
        if(cur==sum/2){
            res=true;
            return;
        }
        if(cur>sum/2)
            return;
        if(set.contains(cur))return;
        for(int i=0;i<nums.length;i++){
            if(seen[i]==true)continue;
            seen[i]=true;
            dfs(nums,cur+nums[i],seen);
            set.add(cur+nums[i]);
            seen[i]=false;
        }
    }
    }
}
// @lc code=end

