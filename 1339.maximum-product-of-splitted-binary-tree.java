/*
 * @lc app=leetcode id=1339 lang=java
 *
 * [1339] Maximum Product of Splitted Binary Tree
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
    long sum=0;
    long max=0;
    public int maxProduct(TreeNode root) {
        sum=sum(root);
        sum(root);
        return (int)(max % (1e9 + 7));
    }
    public int sum(TreeNode root){

        if(root==null)return 0;

        int left=sum(root.left);
        int right=sum(root.right);

        int v=root.val+left+right;
        max=Math.max(max,left*(sum-left));
        max=Math.max(max,right*(sum-right));
        
        return v;
    }
}
// @lc code=end

