/*
 * @lc app=leetcode id=1609 lang=java
 *
 * [1609] Even Odd Tree
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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean even=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            int pre=even?Integer.MIN_VALUE:Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(even&&(node.val%2==0||pre>=node.val))
                   return false;
                if(!even&&(node.val%2==1||pre<=node.val))
                   return false;            
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
                pre=node.val;
            }
            even=!even;
        }
        return true;
    }
}
// @lc code=end

