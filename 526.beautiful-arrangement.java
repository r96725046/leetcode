/*
 * @lc app=leetcode id=526 lang=java
 *
 * [526] Beautiful Arrangement
 */

// @lc code=start
class Solution {
    int count=0;
    public int countArrangement(int n) {
        int[] used=new int[n+1];

        backtrack(n,1,used);
        return count;
    }
    public void backtrack(int n,int pos,int[] used){

        if(pos>n){
            count++;
            return;
        }
        for(int i=1;i<used.length;i++){
            if(used[i]==0&&(i%pos==0||pos%i==0)){
                used[i]=1;
                backtrack(n,pos+1,used);
                used[i]=0;
            }
        }

    }
}
// @lc code=end

