/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        if(root==null)return list;
        TreeNode cur=root;
        stack.push(cur);
        while(!stack.isEmpty()){
            cur=stack.pop();
            list.add(cur.val);
            if(cur.right!=null)
               stack.push(cur.right);
            if(cur.left!=null)
               stack.push(cur.left);
            
        }
        return list;
    }
}
// @lc code=end

