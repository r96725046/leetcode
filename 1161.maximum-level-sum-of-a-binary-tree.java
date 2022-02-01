/*
 * @lc app=leetcode id=1161 lang=java
 *
 * [1161] Maximum Level Sum of a Binary Tree
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
    public int maxLevelSum(TreeNode root) {
        
        int lv=0;
        int max=Integer.MIN_VALUE;

        Queue<TreeNode> queue=new LinkedList<>();
        int deep=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            deep++;
            int sum=0;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                sum+=cur.val;
                if(cur.left!=null)queue.offer(cur.left);
                if(cur.right!=null)queue.offer(cur.right);            
            }
            if(sum>max)
            {
                lv=deep;
                max=sum;
            }
        }

        return lv;
    }
}
// @lc code=end

