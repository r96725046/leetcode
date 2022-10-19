/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        int[] arr=new int[100001];
        int count=0;
        int start=0;
        int max=0;
        for(int i=0;i<fruits.length;i++){
            if(arr[fruits[i]]==0)
                count++;
            arr[fruits[i]]++;
            while(count>2){
                arr[fruits[start]]--;
                if(arr[fruits[start]]==0)
                    count--;
                start++;
            }
            max=Math.max(max,i-start+1);
        }
        return max;
    }
}
// @lc code=end

