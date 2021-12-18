/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        int count=0;
        int n=0;
        int r=0;

        ListNode runner=head;
        while(runner!=null){
            runner=runner.next;
            count++;
        }
        r=count%k;
        n=count/k;
        ListNode[] res=new ListNode[k];
        runner=head;
        for(int i=0;i<res.length;i++){
            int c=n;
            if(runner==null)break;
            res[i]=runner;
            ListNode pre=null;
            while(c>0&&runner!=null){
                pre=runner;
                runner=runner.next;
                c--;

            }
            if(r>0&&runner!=null){
                r--;
                pre=runner;
                runner=runner.next;
            }
            pre.next=null;
        }
        return res;
    }
    
}
// @lc code=end

