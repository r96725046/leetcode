/*
 * @lc app=leetcode id=768 lang=java
 *
 * [768] Max Chunks To Make Sorted II
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] sorted=new int[arr.length];
        for(int i=0;i<arr.length;i++)
            sorted[i]=arr[i];
        Arrays.sort(sorted);
        int s1=0;
        int s2=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            s1+=sorted[i];
            s2+=arr[i];
            if(s1==s2)count++;
        }
        return count;
    }
}
// @lc code=end

