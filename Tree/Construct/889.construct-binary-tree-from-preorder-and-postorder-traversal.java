/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
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
    //preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        return build(preorder,0,preorder.length-1,postorder,0,preorder.length-1);

    }
    public TreeNode build(int[] pre,int pStart,int pEnd,int[] post,int pstStart,int pstEnd){

        if(pStart>pEnd)
            return null;

        if(pStart==pEnd)
            return new TreeNode(pre[pStart]);
        TreeNode root=new TreeNode(pre[pStart]);
        int index=map.get(pre[pStart+1]);
        int size=index-pstStart+1;

        root.left=build(pre,pStart+1,pStart+size,post,pstStart,index);
        root.right=build(pre,pStart+size+1,pEnd,post,index+1,pstEnd-1);
        return root;
    }
}
// @lc code=end

