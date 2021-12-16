/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)return null;
        dfs(head);
        return head;
    }
    private Node dfs(Node head){
        
        Node next=head.next;
        if(head.child!=null){
            Node tail=dfs(head.child);
            head.next=head.child;
            head.next.prev=head;
            head.child=null;
            tail.next=next;
            if(next!=null)
                next.prev=tail;
        }
        if(head.next==null)
            return head;
        return dfs(head.next);
    }



}
// @lc code=end

