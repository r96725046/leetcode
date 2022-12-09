/*
 * @lc app=leetcode id=632 lang=java
 *
 * [632] Smallest Range Covering Elements from K Lists
 */

// @lc code=start
class Solution {
    class Item{
        int row;
        int index;
        int val;
        public Item(int r,int i, int v){
            this.row=r;
            this.index=i;
            this.val=v;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
    
        PriorityQueue<Item> q=new PriorityQueue<>((x,y)-> x.val-y.val);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++)
        {
            List<Integer> l=nums.get(i);
            q.offer(new Item(i,0,l.get(0)));
            max=Math.max(l.get(0),max);
        }
        int range=Integer.MAX_VALUE;
        int[] res=new int[2];
        while(q.size()==nums.size()){

            Item cur=q.poll();
            if(max-cur.val<range)
            {
                range=Math.min(range,max-cur.val);
                res[0]=cur.val;
                res[1]=max;
            }
            if(cur.index<nums.get(cur.row).size()-1){
                int v=nums.get(cur.row).get(cur.index+1);
                q.offer(new Item(cur.row,cur.index+1,v));
                max=Math.max(v,max);
            }
        }
        return res;
    }
}
// @lc code=end

