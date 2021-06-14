/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // **
    // 1. Node dummy
    // 2. Node dummyRunner
    // 3. return dummy.next
    public Node copyRandomList(Node head) {

        Node runner=head;

        while(runner!=null){
            Node next=runner.next;
            runner.next=new Node(runner.val);
            runner.next.next=next;
            runner=runner.next.next;
        }
        runner=head;
        while(runner!=null){
            if(runner.random!=null){
               Node random=runner.random;
                runner.next.random=random.next;// *** random.next
            }
            runner=runner.next.next;
        }
        runner=head;
        Node cphead=new Node(0);
        Node cprunner=cphead;
        while(runner!=null){
            cprunner.next=runner.next;
            runner.next=runner.next.next;
            
            runner=runner.next;
            cprunner=cprunner.next;
        }
        cprunner.next=null;
        return cphead.next;
    }
}
// @lc code=end

