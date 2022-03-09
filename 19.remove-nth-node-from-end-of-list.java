/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy=new ListNode(0);
            dummy.next=head;
            ListNode fast=head;
            ListNode slow=dummy;

            while(n>0&&fast!=null){
                fast=fast.next;
                n--;
            }
            while(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            if(slow.next!=null)
                slow.next=slow.next.next;

            return dummy.next;
    }
}
// @lc code=end

