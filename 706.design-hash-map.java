/*
 * @lc app=leetcode id=706 lang=java
 *
 * [706] Design HashMap
 */

// @lc code=start
class MyHashMap {
    class Node{
        int key;
        int value;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    int cap=1000;
    List<Node>[] bucket;
    public MyHashMap() {
        bucket=new LinkedList[cap];
    }
    public int getPos(int key){
        
        int index=key%cap;
        if(bucket[index]==null)return -1;
        List<Node> list=bucket[index];
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).key==key)return i;
        }
        
        return -1;
    }
    public void put(int key, int value) {
        int index=key%cap;
        if(bucket[index]==null)
            bucket[index]=new LinkedList<Node>();
        
        int i=getPos(key);
        if(i<0){
            bucket[index].add(new Node(key,value));
        }else{
            bucket[index].get(i).value=value;
        }
    }
    
    public int get(int key) {
        int index=key%cap;
        if(bucket[index]==null)return -1;
        int i=getPos(key);
        if(i<0)
        {
            return i;
        }else{
            return bucket[index].get(i).value;
        }
        
    }
    
    public void remove(int key) {
        int index=key%cap;
        if(bucket[index]==null)return;
        
        int i=getPos(key);
        if(i<0)
            return;
        else{
            List<Node> list=bucket[index];
            list.set(i,list.get(list.size()-1));
            list.remove(list.size()-1);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

