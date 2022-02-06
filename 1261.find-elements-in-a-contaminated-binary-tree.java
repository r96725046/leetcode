/*
 * @lc app=leetcode id=1261 lang=java
 *
 * [1261] Find Elements in a Contaminated Binary Tree
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
class FindElements {
    Set<Integer> s=new HashSet<>();
    public FindElements(TreeNode root) {
        root.val=0;
        s.add(root.val);
        dfs(root);
    }
    private void dfs(TreeNode root){
        
        if(root.left!=null){
            root.left.val=2*root.val+1;
            s.add(root.left.val);
            dfs(root.left);
        }
        if(root.right!=null){
            root.right.val=2*root.val+2;
            s.add(root.right.val);
            dfs(root.right);
        }
    }
    public boolean find(int target) {
        return s.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
// @lc code=end

