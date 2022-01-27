/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
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
    int l=0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root,Integer.MIN_VALUE);
        return l;
    }
    public int dfs(TreeNode root,int val){

        if(root==null) return 0;

        int left=dfs(root.left,root.val);
        int right=dfs(root.right,root.val);
        l=Math.max(l,left+right);
        if(root.val==val)return Math.max(left,right)+1;
        return 0;

    }
}
// @lc code=end

