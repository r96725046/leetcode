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
    // https://www.youtube.com/watch?v=ScCg9v921ns
    // swing in Array 1 between 0~"len1" because it needs i & i-1
    // 1.if(len1>len2)return findMedianSortedArrays(nums2,nums1);
    // 2.*if(len1==0)return ((double)nums2[(len2-1)/2]+(double)nums2[len2/2])/2;
    //
    // 3.i>0 && al(i-1)>br(j) =>i move left end=i-1
    // 4.i<len && bl(j-1)>ar(i) =>i move right stard=i+1
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
            return findMedianSortedArrays(nums2,nums1);
        if(nums1.length==0)
            return ((double)nums2[(nums2.length-1)/2]+
                    (double)nums2[nums2.length/2])/2;
        int[] a=nums1;
        int[] b=nums2;
        int start=0;
        int end=a.length;
        int i,j;
        while(start<=end){
            i=(start+end)/2;
            j=(a.length+b.length+1)/2-i;

            if(i>0&&a[i-1]>b[j])
                end=i-1;
            else if(i<a.length&&b[j-1]>a[i])
                start=i+1;
            else{
                double left;
                if(i==0)
                    left=b[j-1];
                else if(j==0)
                    left=a[i-1];
                else
                    left=Math.max(a[i-1],b[j-1]);

                if((a.length+b.length)%2==1)
                    return left;

                double right;
                if(i==a.length)
                    right=b[j];
                else if(j==b.length)
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

