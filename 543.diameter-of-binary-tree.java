/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        traversal(root);
        return max;
    }
    public int traversal(TreeNode root){
        
        if(root==null)
            return 0;
        
        int left=traversal(root.left);
        int right=traversal(root.right);
        
        max=Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
}
// @lc code=end

