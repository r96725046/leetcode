/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 */
import java.util.*;
// @lc code=start
class Solution {
    // dfs
    // ***
    // 1.cur.size()>1 add
    // 2.hasmap for the same nums[i]
    List<List<Integer>> list=new ArrayList<List<Integer>>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        traversal(nums,0,new ArrayList<Integer>());
        return list;
    }

    public void traversal(int[] nums,int index,ArrayList<Integer> cur){

        if(cur.size()>1)
            list.add(new ArrayList<Integer>(cur));

        Set<Integer> set=new HashSet<Integer>();
        for(int i=index;i<nums.length;i++){
            if (set.contains(nums[i]))continue;
            if(cur.size()==0||nums[i]>=cur.get(cur.size()-1)){
                cur.add(nums[i]);
                set.add(nums[i]);
                traversal(nums,i+1,cur);
                cur.remove(cur.size()-1);
            }
        }


    }
}
// @lc code=end

