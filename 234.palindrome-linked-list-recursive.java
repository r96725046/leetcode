/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
class Solution {
    ListNode left;
    public boolean isPalindrome(ListNode head) {
       left=head;
       return traversal(head);
    }
    public boolean traversal(ListNode head){
        if(head==null)
            return true;
        boolean result=traversal(head.next);
        result=result&&(head.val==left.val);
        left=left.next;
        return result;

    }
}
// @lc code=end

