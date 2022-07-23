/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] seen=new boolean[nums.length];
        backtrack(nums,0,seen,new ArrayList<Integer>());
        return res;
    }
    public void backtrack(int[] nums,int index,boolean[] seen,ArrayList<Integer> cur){

        if(index==nums.length){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(seen[i])continue;
            seen[i]=true;
            cur.add(nums[i]);
            backtrack(nums,index+1,seen,cur);
            seen[i]=false;
            cur.remove(cur.size()-1);
        }
    }
}
// @lc code=end

