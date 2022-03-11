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
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        ListNode dummy=new ListNode(0);
        while(slow!=null){
            ListNode tmp=dummy.next;
            dummy.next=slow;
            slow=slow.next;
            dummy.next.next=tmp;
        }
        
        slow=dummy.next;
        while(slow!=null&&head!=null){
            if(slow.val!=head.val)return false;
            slow=slow.next;
            head=head.next;
        }
        return true;
    }
}
// @lc code=end

