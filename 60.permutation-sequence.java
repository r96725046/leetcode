/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    // ****
    // k-- 0~k-1
    // k/n-1 to get index
    // k%n-1 to get next position
    public String getPermutation(int n, int k) {
        k--;

        int f=1;
        List<Integer> arr=new ArrayList<>();
        for(int i=1;i<=n;i++)
            arr.add(i);
        for(int i=2;i<n;i++){
            f=f*i;      
        }
        int index=0;
        int time=n-1;
        String res="";
        for(int i=1;i<n;i++){
            index=k/f;
            res+=arr.get(index);
            arr.remove(index);

            k=k%f;
            f=f/time;
            time--;
        }
        res+=arr.get(0);
        return res;
    }
}
// @lc code=end

