/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    //1.if(head==end)return null;
    //2.while(fast!=end&&fast.next!=end)
    public TreeNode sortedListToBST(ListNode head) {
        return dfs(head,null);
    }
    public TreeNode dfs(ListNode head,ListNode end){
        ListNode slow=head;
        ListNode fast=head;
        if(head==end)return null;
        while(fast!=end&&fast.next!=end){
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode node=new TreeNode(slow.val);
        node.left=dfs(head,slow);
        node.right=dfs(slow.next,end);
        return node;
    }
}
// @lc code=end

