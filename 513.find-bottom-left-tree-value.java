/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
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
    int lv=-1;
    int res=0;
    public int findBottomLeftValue(TreeNode root) {
        
        traverse(root,0);
        return res;
    }
    private void traverse(TreeNode root, int level){

        if(root==null)return;
        traverse(root.left,level+1);
        if(level>lv){
            lv=level;
            res=root.val;
        }
        traverse(root.right,level+1);
    }
}
// @lc code=end

