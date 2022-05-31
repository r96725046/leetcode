/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    int cap=0;
    int count=0;
    Node head;
    Node tail;
    HashMap<Integer,Node> map;
    public LRUCache(int capacity) {
        cap=capacity;
        map=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.pre=head;
    }
    private void addToHead(Node node){
        Node tmp=head.next;
        head.next=node;
        node.pre=head;
        node.next=tmp;
        tmp.pre=node;
    }
    private void removeNode(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            removeNode(node);
            addToHead(node);
            return node.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int val) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=val;
            removeNode(node);
            addToHead(node);
        }else{
            Node node=new Node(key,val);
            if(count==cap){
                Node pre=tail.pre;
                removeNode(pre);
                map.remove(pre.key);
                count--;
            }
            count++;
            addToHead(node);
            map.put(key,node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

