/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    // **
    // 1.for+while
    // 2.i++ p--, i-- p++
    public int largestRectangleArea(int[] heights) {

        int[] left=new int[heights.length];
        int[] right=new int[heights.length];
        right[right.length-1]=right.length;
        left[0]=-1;
        //Scan left items
        for(int i=1;i<heights.length;i++){
            int p=i-1;
            while(p>=0&&heights[p]>=heights[i]){
                p=left[p];//use left[p] instead of p--
            }
            left[i]=p;
        }
        //Scan right items
        for(int i=right.length-2;i>=0;i--){
            int p=i+1;
            while(p<=right.length-1&&heights[p]>=heights[i])
                p=right[p];
            right[i]=p;
        }

        int max=0;

        for(int i=0;i<heights.length;i++)
            max=Math.max(max,heights[i]*(right[i]-left[i]-1));
        return max;
        
    }
}
// @lc code=end

