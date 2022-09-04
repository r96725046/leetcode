/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    class Pair{
        int key;
        int count;
        public Pair(int key,int count){
            this.key=key;
            this.count=count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        PriorityQueue<Pair> queue=new PriorityQueue<>(k,(x,y)->x.count-y.count);
        
        for(int key:map.keySet()){
            queue.offer(new Pair(key,map.get(key)));
            if(queue.size()>k)
                queue.poll();
        }
        int[] res=new int[k];
        for(int i=res.length-1;i>=0;i--){
            res[i]=queue.poll().key;
        }
        return res;
    }
}
// @lc code=end

