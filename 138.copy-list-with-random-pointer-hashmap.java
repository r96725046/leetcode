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
    // next=map.get
    // random=map.get
    // 1
    public Node copyRandomList(Node head) {

        HashMap<Node,Node> map=new HashMap<>();
        Node runner=head;
        while(runner!=null){
            map.put(runner,new Node(runner.val));
            runner=runner.next;
        }

        runner=head;
        while(runner!=null){
            Node cp=map.get(runner);
            cp.next=map.get(runner.next);
            cp.random=map.get(runner.random);
            runner=runner.next;
        }
        return map.get(head);
    }
}
// @lc code=end

