/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,postorder,0,inorder.length-1);
    }
    public TreeNode build(int[] in,int iStart,int iEnd,int[] post,int pStart,int pEnd){

        if(pStart>pEnd)
            return null;

        TreeNode root=new TreeNode(post[pEnd]);
        int index=map.get(post[pEnd]);
        int rightSize=iEnd-index;

        root.left=build(in,iStart,index-1,post,pStart,pEnd-1-rightSize);
        root.right=build(in,index+1,iEnd,post,pEnd-rightSize,pEnd-1);
        return root;

    }
}
// @lc code=end

