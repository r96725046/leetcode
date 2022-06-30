/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
         PriorityQueue<Integer> pq=new PriorityQueue<>((x,y)->Integer.compare(y,x));
        for(int i=0;i<stones.length;i++)
            pq.offer(stones[i]);
        if(pq.size()==1)
            return pq.peek();
        
        while(pq.size()>1){    
            int cur=pq.poll();
            int next=pq.poll();
            if(cur!=next)
                pq.offer(cur-next);
        }
        return pq.size()==1?pq.peek():0;
    }
}
// @lc code=end

