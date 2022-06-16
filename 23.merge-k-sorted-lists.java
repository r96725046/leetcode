/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq=new PriorityQueue<>((x,y)->Integer.compare(x.val,y.val));

        for(ListNode node:lists)
        {
            if(node!=null)
                pq.offer(node);
        }
        ListNode dummy=new ListNode(-1);
        ListNode runner=dummy;
        while(!pq.isEmpty())
        {
            ListNode node=pq.poll();
            runner.next=node;
            runner=runner.next;
            if(node.next!=null)
               pq.offer(node.next);
        }    
        
        return dummy.next;
    }
}
// @lc code=end

