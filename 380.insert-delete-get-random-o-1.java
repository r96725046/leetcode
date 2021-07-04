/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        r=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;

        int pos=map.get(val);
        int lastVal=list.get(list.size()-1);
     
        list.set(pos,lastVal);
        map.put(lastVal,pos);

        list.remove(list.size()-1);
        map.remove(val);
       
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int pos=r.nextInt(list.size());
        return list.get(pos);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

