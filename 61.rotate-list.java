/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        int count=0;
        ListNode runner=head;
        while(runner!=null)
        {
            runner=runner.next;
            count++;
        }
        k=k%count;
        if(k==0)return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        
        while(fast.next!=null){
            fast=fast.next;
            k--;
            if(k<0)
                slow=slow.next;
        }

        dummy.next=slow.next;
        slow.next=null;
        fast.next=head;
        return dummy.next;
    }
}
// @lc code=end

