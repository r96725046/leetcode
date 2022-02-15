/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        if(root==null)return list;
        TreeNode cur=root;
        stack.push(root);
        while(!stack.isEmpty()){
            cur=stack.pop();
            list.add(0,cur.val);
            if(cur.left!=null)
                stack.push(cur.left);
            if(cur.right!=null)
                stack.push(cur.right);
        }   
        return list;
    }
}
// @lc code=end

