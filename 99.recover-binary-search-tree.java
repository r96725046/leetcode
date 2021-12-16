/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    TreeNode pre=null;
    TreeNode a=null;
    TreeNode b=null;
    public void recoverTree(TreeNode root) {

        traverse(root);

        int tmp=a.val;
        a.val=b.val;
        b.val=tmp;
    }
    private void traverse(TreeNode root){
        if(root==null)return;
        traverse(root.left);

        if(pre!=null&&pre.val>=root.val){
           if(a==null)a=pre;
           b=root;
        }
        pre=root;
        traverse(root.right);

    }
}
// @lc code=end

