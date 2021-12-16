/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer> map;
    int max=1;
    public int[] findFrequentTreeSum(TreeNode root) {
        map=new HashMap<>();
        dfs(root);
        List<Integer> list=new ArrayList<>();
        for(Integer key:map.keySet()){
            if(map.get(key)==max)
                list.add(key);
        }
        int[] res=new int[list.size()];
        for(int i=0;i<list.size();i++)
            res[i]=list.get(i);
        return res;
    }
    private int dfs(TreeNode root){
        if(root==null)return 0;
        int sum=root.val+dfs(root.left)+dfs(root.right);

        if(map.containsKey(sum)){
            map.put(sum,map.get(sum)+1);
            if(map.get(sum)>max)max=map.get(sum);
        }else
            map.put(sum,1);
        return sum;
    }
}
// @lc code=end

