/*
 * @lc app=leetcode id=1346 lang=java
 *
 * [1346] Check If N and Its Double Exist
 */

// @lc code=start
class Solution {
    public boolean checkIfExist(int[] arr) {
         HashSet<Integer> set=new HashSet<>();
        
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]*2)||(arr[i]%2==0&&set.contains(arr[i]/2)))
               return true;
            set.add(arr[i]);
        }
        return false;
    }
}
// @lc code=end

