/*
 * @lc app=leetcode id=814 lang=java
 *
 * [814] Binary Tree Pruning
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
    public TreeNode pruneTree(TreeNode root) {
        int sum=dfs(root);
        return sum==0?null:root;
    }
    public int dfs(TreeNode root){

        if(root==null)return 0;

        int left=dfs(root.left);
        int right=dfs(root.right);

        if(left==0)root.left=null;
        if(right==0)root.right=null;

        return root.val+left+right;
    }
}
// @lc code=end

