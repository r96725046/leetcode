/*
 * @lc app=leetcode id=865 lang=java
 *
 * [865] Smallest Subtree with all the Deepest Nodes
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
    //1.one pass
    //2.if(root==null)return level;
    //3.update deepest level and res;
    int lv=0;
    TreeNode res=null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root,0);
        return res;
    }
    
    public int dfs(TreeNode root,int level){
        if(root==null)return level;
        
        int l=dfs(root.left,level+1);
        int r=dfs(root.right,level+1);

        int cur=Math.max(l,r);
        lv=Math.max(lv,cur);

        if(lv==l&&lv==r)
            res=root;
        return cur;
    }
}
// @lc code=end

