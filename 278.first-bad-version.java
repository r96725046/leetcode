/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l=1;
        int r=n;

        while(l<=r){
            int mid=(r-l)/2+l;
            if(isBadVersion(mid))
                r=mid-1;
            else
                l=mid+1;
        }
        if(l>n||!isBadVersion(l))
            return -l;
        else
            return l;
    }
}
// @lc code=end

