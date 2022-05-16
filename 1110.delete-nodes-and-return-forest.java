/*
 * @lc app=leetcode id=1110 lang=java
 *
 * [1110] Delete Nodes And Return Forest
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
    HashSet<Integer> set=new HashSet<>();
    List<TreeNode> res=new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int v:to_delete)
            set.add(v);

        dfs(root,false);
        return res;
    }

    public TreeNode dfs(TreeNode root,boolean hasParent){
        if(root==null)return null;

        boolean isDelete=set.contains(root.val);
        if(!isDelete&&!hasParent){
            res.add(root);
        }
        root.left=dfs(root.left,!isDelete);
        root.right=dfs(root.right,!isDelete);

        if(isDelete)
            return null;
        else
            return root;
    }
}
// @lc code=end

