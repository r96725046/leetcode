/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    // ****
    //        L1 R1 
    //  2 4 6 7  10
    //      L2 R2
    //  1 3 5  8 9 11 12 13 14 
    //1  =>no r1 index==0 =>MAX
    //2 3
    //1 MAX
    //2  3 
    //
    //4  =>no L1,r2 index==len =>MAX
    //2 3
    //Min 4  
    //2 3 MAX

    // swing in Array 1 between 0~len1
    // 1.if(len1>len2)return findMedianSortedArrays(nums2,nums1);
    // 2.if(len1==0)return ((double)nums2[(len2-1)/2]+(double)nums2[len2/2])/2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        if(len1>len2)return findMedianSortedArrays(nums2,nums1);
        if(len1==0)return ((double)nums2[(len2-1)/2]+(double)nums2[len2/2])/2;
        int l=0;
        int r=len1;
        int index1;
        int index2;
        while(l<=r){
            index1=l+(r-l)/2;
            index2=(len1+len2+1)/2-index1;

            double l1=index1==0?Integer.MIN_VALUE:nums1[index1-1];
            double l2=index2==0?Integer.MIN_VALUE:nums2[index2-1];
            double r1=index1==len1?Integer.MAX_VALUE:nums1[index1];
            double r2=index2==len2?Integer.MAX_VALUE:nums2[index2];

            if(l1>r2)
                r=index1-1;
            else if(l2>r1)
                l=index1+1;
            else{
                
                if((len1+len2)%2==1)
                    return Math.max(l1,l2);
                else{
                    double res=Math.max(l1,l2)+Math.min(r1,r2);
                    return res/2;
                }
            }

        }
        return -1;
    }
}
// @lc code=end

