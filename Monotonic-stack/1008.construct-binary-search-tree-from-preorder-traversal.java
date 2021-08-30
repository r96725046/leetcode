/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0)return null;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode root=new TreeNode(preorder[0]);
        stack.push(root);
        for(int i=1;i<preorder.length;i++){
            TreeNode cur=new TreeNode(preorder[i]);
            
            TreeNode pre=null;
            while(!stack.isEmpty()&&cur.val>stack.peek().val){
                pre=stack.pop();
            }
            if(pre!=null)
                pre.right=cur;
            else 
            {   
                if(!stack.isEmpty())
                    stack.peek().left=cur;
            }
            stack.push(cur);
        }
        return root;
    }
}
// @lc code=end

