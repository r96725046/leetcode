/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        
        int l=0;
        int r=height.length-1;
        int res=0;
        while(l<r){

            int min=Math.min(height[l],height[r]);
            res=Math.max(res,(r-l)*min);
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return res;
    }
}
// @lc code=end

