/*
 * @lc app=leetcode id=988 lang=java
 *
 * [988] Smallest String Starting From Leaf
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
    String res="";
    public String smallestFromLeaf(TreeNode root) {
        if(root==null)return"";
        dfs(root,0,"");
        return res;
    }
    public void dfs(TreeNode root,int v,String suffix){
        String cur=(char)(root.val+'a')+suffix;
        if(root.left==null&&root.right==null)
        {
            if(res.length()==0||cur.compareTo(res)<0){
                res=(char)(root.val+'a')+suffix;
            }
        }
        if(root.left!=null)dfs(root.left,root.val+v,cur);
        if(root.right!=null)dfs(root.right,root.val+v,cur);


    }
}
// @lc code=end

