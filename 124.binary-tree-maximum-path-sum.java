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
    // 3. 4 cases
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
            dfs(root);
            return max;
    }
    private int dfs(TreeNode root){
        if(root==null)
            return 0;
        int l=dfs(root.left);
        int r=dfs(root.right);
        int sum=Math.max(root.val,Math.max(root.val+l,root.val+r));
        max=Math.max(max,Math.max(sum,root.val+l+r));
        return sum;
        // int sub=Math.max(root.val+l,root.val+r);
        // int curMax=Math.max(sub,Math.max(root.val,root.val+l+r));
        // max=Math.max(max,curMax);
        // return Math.max(root.val,sub);
    }

}
// @lc code=end

