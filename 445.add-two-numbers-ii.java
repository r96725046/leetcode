/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1=new Stack<>();
        Stack<ListNode> s2=new Stack<>();

        while(l1!=null){
            s1.push(l1);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2);
            l2=l2.next;
        }

        ListNode next=null;
        ListNode dummy=new ListNode(-1);
        int carry=0;
        while(!s1.isEmpty()&&!s2.isEmpty()){
            next=dummy.next;
            l1=s1.pop();
            l2=s2.pop();
            ListNode node=new ListNode(l1.val+l2.val+carry);
            carry=node.val/10;
            node.val=node.val%10;
            node.next=next;
            dummy.next=node;
        }
        Stack<ListNode> cur=s1.isEmpty()?s2:s1;
        while(!cur.isEmpty()){
            next=dummy.next;
            l1=cur.pop();
            l1.val+=carry;
            carry=l1.val/10;
            l1.val=l1.val%10;
            l1.next=next;
            dummy.next=l1;
        }
        if(carry>0){
            dummy.val=carry;
        }
        return dummy.val>0?dummy:dummy.next;
    }
}
// @lc code=end

