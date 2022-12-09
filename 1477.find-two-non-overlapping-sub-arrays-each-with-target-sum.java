/*
 * @lc app=leetcode id=1477 lang=java
 *
 * [1477] Find Two Non-overlapping Sub-arrays Each With Target Sum
 */

// @lc code=start
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        

        int[] minLen=new int[arr.length];
        for(int i=0;i<minLen.length;i++)
            minLen[i]=Integer.MAX_VALUE;

        int cur=0;
        int start=0;
        int res=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){

            cur+=arr[i];
            while(cur>target){
                cur-=arr[start];
                start++;
            }
            if(cur==target){
                int l=i-start+1;
                if(start>0&&minLen[start-1]!=Integer.MAX_VALUE){
                    res=Math.min(res,minLen[start-1]+l);
                }
                min=Math.min(min,l);
            }
            minLen[i]=min;
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
// @lc code=end

