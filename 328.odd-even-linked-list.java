/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode odd=new ListNode(0);
        ListNode runnerOdd=odd;
        ListNode even=new ListNode(0);
        ListNode runnerEven=even;
        boolean isOdd=true;
        while(head!=null){
            ListNode tmp=head.next;
            if(isOdd){
                runnerOdd.next=head;
                runnerOdd=runnerOdd.next;
                runnerOdd.next=null;
            }else{
                runnerEven.next=head;
                runnerEven=runnerEven.next;
                runnerEven.next=null;
            }
            head=tmp;
            isOdd=!isOdd;
        }
        runnerOdd.next=even.next;
        return odd.next;
    }
}
// @lc code=end

