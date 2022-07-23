/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        
        backtrack(nums,0,new ArrayList<Integer>());
        return res;
    }
    public void backtrack(int[] nums,int index,ArrayList<Integer> cur){

        if(index>nums.length)
            return;
        
        res.add(new ArrayList<Integer>(cur));

        for(int i=index;i<nums.length;i++){
            cur.add(nums[i]);
            backtrack(nums,i+1,cur);
            cur.remove(cur.size()-1);
        }

    }
}
// @lc code=end

