/*
 * @lc app=leetcode id=705 lang=java
 *
 * [705] Design HashSet
 */

// @lc code=start
class MyHashSet {

    boolean[] bucket;
    public MyHashSet() {
        bucket=new boolean[1000001];
    }
    
    public void add(int key) {
        bucket[key]=true;
    }
    
    public void remove(int key) {
        bucket[key]=false;
    }
    
    public boolean contains(int key) {
        return bucket[key];
    }
    
    public boolean contains(int key) {
        
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

