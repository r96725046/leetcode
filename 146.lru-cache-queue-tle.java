/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    int cap;
    HashMap<Integer,Integer> map=new HashMap<>();
    Queue<Integer> queue=new LinkedList<>();
    //Queue.remove
    public LRUCache(int capacity) {
        cap=capacity;
        map=new HashMap<>();
        queue=new LinkedList<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            int value=map.get(key);
            queue.remove(key);
            queue.offer(key);
            return value;
        }else
            return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
           int tmp=map.get(key);
           queue.remove(key);
        }
        else if(map.size()==cap){
            int curKey=queue.poll();
            map.remove(curKey);
        }
        queue.offer(key);
        map.put(key,value);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

