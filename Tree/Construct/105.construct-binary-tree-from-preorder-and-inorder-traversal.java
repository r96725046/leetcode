/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    // ****
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0,0,preorder.length-1,preorder,inorder);
    }
    public TreeNode build(int pStart, int inStart,int inEnd,int[] pre,int[] in){

        if(pStart>=pre.length||inStart>inEnd)return null;

        TreeNode root=new TreeNode(pre[pStart]);
        int index=0;
        for(int i=inStart;i<=inEnd;i++){
            if(in[i]==pre[pStart]){
                index=i;
                break;
            }
        }

        root.left=build(pStart+1,inStart,index-1,pre,in);
        root.right=build(pStart+(index-inStart)+1,index+1,inEnd,pre,in);
        return root;
    }
}
// @lc code=end

