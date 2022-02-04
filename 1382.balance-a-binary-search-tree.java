/*
 * @lc app=leetcode id=1382 lang=java
 *
 * [1382] Balance a Binary Search Tree
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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        traverse(root,list);
        return dfs(list,0,list.size()-1);
    }
    public void traverse(TreeNode root,List<TreeNode> list){
        if(root==null)return;
        traverse(root.left,list);
        list.add(root);
        traverse(root.right,list);
    }
    public TreeNode dfs(List<TreeNode> list,int lo,int hi){

        if(lo>hi)return null;

        int mid=(lo+hi)/2;

        TreeNode node=list.get(mid);

        node.left=dfs(list,lo,mid-1);
        node.right=dfs(list,mid+1,hi);
        return node;
    }
}
// @lc code=end

