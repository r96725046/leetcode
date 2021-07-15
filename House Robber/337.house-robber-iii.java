/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
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
    // Array length 2
    // arr[0]=>Rob = val+ left[1]+right[1]
    // arr[1]=>Not rob, rob or not rob subtrees
    //       = Max(left[0],left[1])+Max(right[0],right[1])
    public int rob(TreeNode root) {
        int[] res=dfs(root);
        return Math.max(res[0],res[1]);
    }
    private int[] dfs(TreeNode root){

        if(root==null)return new int[2];

        int[] left=dfs(root.left);
        int[] right=dfs(root.right);

        int[] res=new int[2];
        res[0] = root.val+left[1]+right[1];
        res[1] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return res;
    }
}
// @lc code=end

