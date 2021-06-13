/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
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
    // **
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)return subRoot==null;

        if(isSame(root,subRoot))
            return true;
        else
            return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot
            );
    }
    private boolean isSame(TreeNode left,TreeNode right){
        if(left==null&&right==null)
            return true;
        else if(left==null||right==null)
            return false;
        else{
            if(left.val!=right.val)
                return false;
            else
                return isSame(left.left,right.left)&&isSame(left.right,right.right);
        }
    }
}
// @lc code=end

