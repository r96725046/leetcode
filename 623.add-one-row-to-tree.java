/*
 * @lc app=leetcode id=623 lang=java
 *
 * [623] Add One Row to Tree
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1)
        {
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int d=1;
        
        while(!q.isEmpty()&&d<depth){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(d==depth-1){
                    TreeNode left=new TreeNode(val);
                    TreeNode right=new TreeNode(val);
                    left.left=cur.left;
                    right.right=cur.right;
                    cur.left=left;
                    cur.right=right;
                   
                }
                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);
            }
            d++;
        }
        return root;
    }
}
// @lc code=end

