/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int max=1;
        int start=0;
        int end=0;
        HashMap<TreeNode,Integer> map=new HashMap<>();
        map.put(root,1);
        while(!q.isEmpty())
        {
            int l=q.size();

            for(int i=0;i<l;i++){

                TreeNode node=q.poll();
                if(i==0)start=map.get(node);
                if(i==l-1)end=map.get(node);
                if(node.left!=null){
                    map.put(node.left,map.get(node)*2);
                    q.offer(node.left);
                }
                if(node.right!=null){
                    map.put(node.right,map.get(node)*2+1);
                    q.offer(node.right);
                }
            }
            max=Math.max(end-start+1,max);
        }
        return max;
    }
}
// @lc code=end

