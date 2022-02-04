/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
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
    // 1.O(n)
    // 2.O(h)
    boolean found=false;
    List<TreeNode> list=new ArrayList<>();
    public TreeNode deleteNode(TreeNode root, int key) {
        dfs(root,key);

        if(!found)return root;
        return helper(0,list.size()-1);
    }
    public TreeNode helper(int lo,int hi){
        if(lo>hi)return null;

        int mid=(lo+hi)/2;

        TreeNode cur=list.get(mid);
        cur.left=helper(lo,mid-1);
        cur.right=helper(mid+1,hi);
        return cur;
    }
    public void dfs(TreeNode root,int key){

        if(root==null)return;
        dfs(root.left,key);
        if(root.val==key)
            found=true;
        else
            list.add(root);
        dfs(root.right,key);
    }
}
// @lc code=end

