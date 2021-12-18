/*
 * @lc app=leetcode id=826 lang=java
 *
 * [826] Most Profit Assigning Work
 */

// @lc code=start
class Solution {
    class Pair{
        int d;
        int p;
        public Pair(int d,int p){
            this.d=d;
            this.p=p;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Pair[] arr=new Pair[difficulty.length];
        for(int i=0;i<difficulty.length;i++)
            arr[i]=new Pair(difficulty[i],profit[i]);

        Arrays.sort(arr,(x,y)->x.d-y.d);
        Arrays.sort(worker);

        int res=0;
        for(int i=0;i<worker.length;i++){
            int cap=worker[i];
            int max=0;
            for(int j=0;j<arr.length;j++){
                if(cap<arr[j].d)break;
                max=Math.max(max,arr[j].p);
            }
            res+=max;
        }

        return res;
    }
}
// @lc code=end

