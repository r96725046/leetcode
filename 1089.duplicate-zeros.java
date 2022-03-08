/*
 * @lc app=leetcode id=1089 lang=java
 *
 * [1089] Duplicate Zeros
 */

// @lc code=start
class Solution {
    public void duplicateZeros(int[] arr) {
        int count=0;
        for(int v:arr)
            if(v==0)count++;
        
        int i=arr.length-1;
        int j=arr.length-1+count;
        while(i>=0){
            if(arr[i]!=0){
                if(j<arr.length)arr[j]=arr[i];
            }else{
                if(j<arr.length)arr[j]=arr[i];
                j--;
                if(j<arr.length)arr[j]=arr[i];
            }
            i--;
            j--;
        }
    }
}
// @lc code=end

