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
    int index=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length)return null;
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return build(0,preorder.length-1,preorder);
    }
    public TreeNode build(int l, int r,int[] pre){

        if(l>r)return null;

        TreeNode root=new TreeNode(pre[index]);
        index++;
     
        root.left=build(l,map.get(root.val)-1,pre);
        root.right=build(map.get(root.val)+1,r,pre);
        return root;
    }
}
// @lc code=end

