/*
 * @lc app=leetcode id=1504 lang=java
 *
 * [1504] Count Submatrices With All Ones
 */

// @lc code=start
class Solution {
    public int numSubmat(int[][] mat) {
        
        int[] sum=new int[mat[0].length];
        int res=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    sum[j]=0;
                    continue;
                }
                sum[j]+=1;
                int min=sum[j];
                for(int k=j;k>=0;k--){
                    min=Math.min(min,sum[k]);
                    res+=min;
                }
            }
        }
        return res;
    }
   
}
// @lc code=end

