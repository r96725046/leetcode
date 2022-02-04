/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    List<String> list=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return list;
    }
    public void dfs(TreeNode root,String res){
        
        if(root==null)return;

        if(res.length()>0)
            res+="->";
        res+=root.val;
        if(root.left==null&&root.right==null)
        {
            list.add(res);
            return;
        }
        dfs(root.left,res);
        dfs(root.right,res);

    }
}
// @lc code=end

