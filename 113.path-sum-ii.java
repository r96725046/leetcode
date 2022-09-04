/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
   List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,new ArrayList<Integer>());
        return res;
    }
    public void dfs(TreeNode root,int targetSum,ArrayList<Integer> cur){
        
        if(root==null)
            return ;
        cur.add(root.val);
        if(targetSum==root.val){
            if(root.left==null&&root.right==null){
                res.add(new ArrayList<Integer>(cur));
                return;
            }
        }
        
        if(root.left!=null){
            dfs(root.left,targetSum-root.val,cur);
            cur.remove(cur.size()-1);
        }
        if(root.right!=null){
            dfs(root.right,targetSum-root.val,cur);
            cur.remove(cur.size()-1);
        }
        
    }
}
// @lc code=end

