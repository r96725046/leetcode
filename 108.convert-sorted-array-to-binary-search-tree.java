/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return traverse(nums,0,nums.length-1);
    }
    public TreeNode traverse(int[] nums,int lo,int hi){

        if(lo>hi)
            return null;

        int mid=(lo+hi)/2;
        TreeNode root=new TreeNode(nums[mid]);

        root.left=traverse(nums,lo,mid-1);
        root.right=traverse(nums,mid+1,hi);
        return root;
    }
}
// @lc code=end

