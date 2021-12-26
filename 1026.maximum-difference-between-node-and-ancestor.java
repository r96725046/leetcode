/*
 * @lc app=leetcode id=1026 lang=java
 *
 * [1026] Maximum Difference Between Node and Ancestor
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
    int diff=0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root,root.val,root.val);
        return diff;
    }
    private void dfs(TreeNode root,int max, int min){
        if(root==null)return;

        max=Math.max(root.val,max);
        min=Math.min(root.val,min);

        diff=Math.max(max-min,diff);
        dfs(root.left,max,min);
        dfs(root.right,max,min);
    }
}
// @lc code=end

