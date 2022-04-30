/*
 * @lc app=leetcode id=705 lang=java
 *
 * [705] Design HashSet
 */

// @lc code=start
class MyHashSet {

    List<Integer>[] bucket;
    int cap=1000;
    public MyHashSet() {
        bucket=new LinkedList[cap];
    }
    
    public void add(int key) {
        if(contains(key))return;

        int index=key%cap;
        if(bucket[index]==null)
            bucket[index]=new LinkedList<>();
        bucket[index].add(key);
    }
    
    public void remove(int key) {
        if(!contains(key))return;

        int index=key%cap;
        List<Integer> list=bucket[index];
        for(int i=0;i<list.size();i++){
            if(list.get(i)==key){
                int v=list.get(list.size()-1);
                list.set(i,v);
                list.remove(list.size()-1);
                break;
            }
        }
    }
    
    public boolean contains(int key) {
        int index=key%cap;
        if(bucket[index]==null)return false;
        List<Integer> list=bucket[index];
        for(int i=0;i<list.size();i++){
            if(list.get(i)==key)return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

