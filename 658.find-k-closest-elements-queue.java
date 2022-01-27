/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
    public class P{
        int n;
        int dif;
        public P(int n, int dif){
            this.n=n;
            this.dif=dif;
        }

    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

            
            PriorityQueue<P> q=new PriorityQueue<>((i,j)->
                i.dif==j.dif?i.n-j.n:i.dif-j.dif);

            for(int i=0;i<arr.length;i++){
                q.offer(new P(arr[i],Math.abs(x-arr[i])));
            }
            List<Integer> res=new ArrayList<>();
            
            while(!q.isEmpty()&&k>0){
                res.add(q.poll().n);
                k--;
            }
            Collections.sort(res);

            return res;

    }
}
// @lc code=end

