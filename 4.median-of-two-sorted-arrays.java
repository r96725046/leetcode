/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    // ****
    // i=(min+max)/2
    // j=(min+max+1)/2-i
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
    // 3.i>0 && al>br =>i move left
    // 4.i<len && bl>ar =>i move right 
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        if(len1>len2)return findMedianSortedArrays(nums2,nums1);
        if(len1==0)return ((double)nums2[(len2-1)/2]+(double)nums2[len2/2])/2;
        int[] a=nums1;
        int[] b=nums2;
        int imin=0;
        int imax=len1;
        int i;
        int j;
        while(imin<=imax){
            i=imin+(imax-imin)/2;
            j=(len1+len2+1)/2-i;

            if(i>0&&a[i-1]>b[j]){
                imax=i-1;
            }else if(i<len1&&b[j-1]>a[i])
                imin=i+1;
            else{

                double left;
                if(i==0)
                    left=b[j-1];
                else if(j==0)
                    left=a[i-1];
                else 
                    left=Math.max(a[i-1],b[j-1]);

                if((len1+len2)%2==1)
                        return left;

                double right;
                if(i==len1)
                    right=b[j];
                else if(j==len2)
                    right=a[i];
                else
                    right=Math.min(a[i],b[j]);
                
                return (left+right)/2;
            }

        }
        return -1;
    }
}
// @lc code=end

