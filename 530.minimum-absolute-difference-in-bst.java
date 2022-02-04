/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
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
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode pre=null;
        int min=Integer.MAX_VALUE;
        while(cur!=null||!stack.isEmpty()){

            while(cur!=null)
            {
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if(pre!=null)
                min=Math.min(min,cur.val-pre.val);
            pre=cur;
            cur=cur.right;
        }
        return min;
    }
}
// @lc code=end

