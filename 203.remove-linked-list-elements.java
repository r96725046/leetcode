/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(0);
        ListNode runner=dummy;
        while(head!=null){
           ListNode tmp=head.next;
           if(head.val!=val){
               runner.next=head;
               runner=runner.next;
               runner.next=null;
           }
            head=tmp;
            
        }
        return dummy.next;
    }
}
// @lc code=end

