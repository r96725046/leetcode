/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int l=0;
        int r=0;

        TreeNode left=root.left;
        TreeNode right=root.right;
        while(left!=null){
            l++;
            left=left.left;
        }
        while(right!=null){
            r++;
            right=right.right;
        }
        if(l==r)
            return (1<<l+1)-1;
        else
            return countNodes(root.left)+countNodes(root.right)+1;

    }
}
// @lc code=end

