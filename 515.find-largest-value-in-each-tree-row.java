/*
 * @lc app=leetcode id=515 lang=java
 *
 * [515] Find Largest Value in Each Tree Row
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
    // 1.while + loop queue size
    // 2.2 queues
    // 3.DFS + List for depth
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> q=new LinkedList<>();
        Queue<TreeNode> nextQ=new LinkedList<>();
        q.offer(root);
        int max=Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            TreeNode n=q.poll();
            if(n.val>=max)
                max=n.val;
            if(n.left!=null)nextQ.offer(n.left);
            if(n.right!=null)nextQ.offer(n.right);
            if(q.size()==0)
            {
                Queue<TreeNode> tmp=q;
                q=nextQ;
                nextQ=tmp;
                res.add(max);
                max=Integer.MIN_VALUE;
            }
        }
        return res;
    }
}
// @lc code=end

