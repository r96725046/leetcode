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
    //preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length)return null;
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return build(0,preorder.length-1,preorder,0,preorder.length-1,inorder);
    }
    public TreeNode build(int pStart, int pEnd,int[] pre,int iStart,int iEnd,int[] in){

        if(pStart>pEnd)return null;

        TreeNode root=new TreeNode(pre[pStart]);
        
        int index=map.get(pre[pStart]);
        int leftSize=index-iStart;

        root.left=build(pStart+1,pStart+leftSize,pre,iStart,index-1,in);
        root.right=build(pStart+leftSize+1,pEnd,pre,index+1,iEnd,in);
        return root;
    }
}
// @lc code=end

