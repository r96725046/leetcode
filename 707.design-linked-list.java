/*
 * @lc app=leetcode id=707 lang=java
 *
 * [707] Design Linked List
 */

// @lc code=start
class MyLinkedList {

    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
    ListNode dummy;
    public MyLinkedList() {
        dummy=new ListNode(-1);
    }
    
    public int get(int index) {
        ListNode runner=dummy.next;
        while(runner!=null){
            if(index==0)return runner.val;
            index--;
            runner=runner.next;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        ListNode tmp=dummy.next;
        dummy.next=new ListNode(val);
        dummy.next.next=tmp;
    }
    
    public void addAtTail(int val) {
        ListNode runner=dummy;
        while(runner.next!=null)
            runner=runner.next;
        runner.next=new ListNode(val);
    }
    
    public void addAtIndex(int index, int val) {
        ListNode runner=dummy;
        while(runner!=null){
            if(index==0){
                ListNode tmp=runner.next;
                runner.next=new ListNode(val);
                runner.next.next=tmp;
                break;
            }
            index--;
            runner=runner.next;
        }  
    }
    
    public void deleteAtIndex(int index) {
        ListNode runner=dummy;
        while(runner!=null&&runner.next!=null){
            if(index==0){
                runner.next=runner.next.next;
            }
            index--;
            runner=runner.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

