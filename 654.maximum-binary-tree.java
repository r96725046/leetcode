/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
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
    //
    // 3 2 1 6 0 5
    // monotonic stack
    // left 6->1,6->2, 6->3
    // left 3->2 2->1
    // right 6->0
    // right 5->0
    // right 6->5
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack=new Stack<>();

        for(int i=0;i<nums.length;i++){

            TreeNode node=new TreeNode(nums[i]);
            while(!stack.isEmpty()&&stack.peek().val<node.val){
                node.left=stack.pop();
            }
            if(!stack.isEmpty()){
                TreeNode p=stack.peek();
                p.right=node;
            }
            stack.push(node);
        }
        TreeNode res=null;
        //if (stack.isEmpty())return res;
        for(TreeNode n:stack)
        {
            res=n;
            break;
        }
        return res;
    }
}
// @lc code=end

