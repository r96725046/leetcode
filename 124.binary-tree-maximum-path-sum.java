/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
    // ***
    // 1.return path sum max (root,root+l,root+r) 
    // 2.max= max (max,max(root,root+l+r,root+l,root+r));
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
            dfs(root);
            return max;
    }
    public int dfs(TreeNode node){
        if(node==null)return 0;

        int l=dfs(node.left);
        int r=dfs(node.right);
        int sum=Math.max(node.val,Math.max(l,r)+node.val);
        max=Math.max(max,Math.max(node.val+l+r,sum));
        return sum;
    }
}
// @lc code=end

