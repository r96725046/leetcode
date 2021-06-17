/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
    // **
    // left && right arr =>find the heights[j] smaller than heights[i]
    // 1.for+while
    // 2.j=i-1 i++ j--,j=i+1 i-- j++
    public int largestRectangleArea(int[] heights) {

       int[] left=new int[heights.length];
       int[] right=new int[heights.length];

       left[0]=-1;
       for(int i=1;i<heights.length;i++){
           int j=i-1;
           while(j>=0){
               if(heights[j]>=heights[i])
                   j=left[j];
               else
                    break;
           }
           left[i]=j;
       }
       right[right.length-1]=right.length;
       for(int i=heights.length-1;i>=0;i--){
           int j=i+1;
           while(j<heights.length){
               if(heights[j]>=heights[i])
                   j=right[j];
               else
                   break;
           }
           right[i]=j;
       }

       int max=0;
       for(int i=0;i<heights.length;i++){
           max=Math.max(max,heights[i]*(right[i]-left[i]-1));
       }
       return max;
    }
}
// @lc code=end

