/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1);
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode r1=list1;
        ListNode r2=list2;
        ListNode r=dummy;
        while(r1!=null&&r2!=null){
            
            if(r1.val>r2.val){
                r.next=r2;
                r2=r2.next;
                r.next.next=null;
            }else{
                r.next=r1;
                r1=r1.next;
                r.next.next=null;
            }
            r=r.next;
        }
        if(r1==null)
            r.next=r2;
        else
            r.next=r1;
        return dummy.next;
    }
}
// @lc code=end

