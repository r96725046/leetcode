/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    int res=0;
    int rank=0;
    public int kthSmallest(TreeNode root, int k) {
        traversal(root,k);
        return res;
    }
    private void traversal(TreeNode root,int k){

        if(root==null)
            return;
        
        traversal(root.left,k);
        rank++;
        if(rank==k)
        {
            res=root.val;
            return;
        }

        traversal(root.right,k);
    }
}
// @lc code=end

