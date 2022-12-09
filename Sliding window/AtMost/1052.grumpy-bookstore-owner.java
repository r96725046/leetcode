/*
 * @lc app=leetcode id=1052 lang=java
 *
 * [1052] Grumpy Bookstore Owner
 */

// @lc code=start
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum=0;
        int cur=0;
        int start=0;
        int max=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0)
                sum+=customers[i];
            if(grumpy[i]==1)
                cur+=customers[i];
            if(i-start+1>minutes){
                if(grumpy[start]==1)
                    cur-=customers[start];
                start++;
            }
            max=Math.max(max,cur);
        }
        return sum+max;
    }
}
// @lc code=end

