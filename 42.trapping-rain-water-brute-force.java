/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int res=0;
        for(int i=1;i<height.length-1;i++){
            int lmax=0;
            int rmax=0;
            for(int j=0;j<=i;j++)
                lmax=Math.max(height[j],lmax);
            
            for(int j=height.length-1;j>=i;j--)
                rmax=Math.max(height[j],rmax);

            res+=Math.min(lmax,rmax)-height[i];
        }
        return res;
    }
}
// @lc code=end

