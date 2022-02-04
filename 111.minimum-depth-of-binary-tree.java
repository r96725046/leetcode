/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    int res=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        dfs(root,1);
        return res;
    }
    public void dfs(TreeNode root,int deep){

        if(root==null)return;

        if(root.left==null&&root.right==null){
            res=Math.min(deep,res);
            return;
        }
        dfs(root.left,deep+1);
        dfs(root.right,deep+1);
    }
}
// @lc code=end

