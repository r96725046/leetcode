/*
 * @lc app=leetcode id=1423 lang=java
 *
 * [1423] Maximum Points You Can Obtain from Cards
 */

// @lc code=start
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] left=new int[cardPoints.length+1];
        int[] right=new int[cardPoints.length+1];

        for(int i=1;i<=k;i++)
        {
            if(i==1)
                left[i]=cardPoints[i-1];
            else
                left[i]=left[i-1]+cardPoints[i-1];
        }
        for(int j=1;j<=k;j++){
            if(j==1)
                right[j]=cardPoints[cardPoints.length-j];
            else
                right[j]=right[j-1]+cardPoints[cardPoints.length-j];
        }
        int max=0;
        //0 3
        //1 2
        //2 1
        //3 0
        for(int i=0;i<=k;i++){
            max=Math.max(max,left[i]+right[k-i]);
        }
        return max;

    }
}
// @lc code=end

