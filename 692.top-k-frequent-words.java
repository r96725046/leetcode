/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public class P{
        String w;
        int c;
        public P(String w,int c)
        {   
            this.w=w;
            this.c=c;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String w:words){
            if(map.containsKey(w))
                map.put(w,map.get(w)+1);
            else
                map.put(w,1);
        }
        PriorityQueue<P> q=new PriorityQueue<>(k,(x,y)->
            x.c==y.c?y.w.compareTo(x.w):x.c-y.c);

        for(String key:map.keySet()){
            q.offer(new P(key,map.get(key)));
            if(q.size()>k)q.poll();
        }
        List<String> res=new ArrayList<>();
        while(!q.isEmpty())
            res.add(0,q.poll().w);
        return res;
    }

}
// @lc code=end

