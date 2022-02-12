/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {
    //d[i][j]=Math.min(Math.min(down,right)+1,d[i][j]);
    public int[][] updateMatrix(int[][] mat) {
        
        int[][] d=new int[mat.length][mat[0].length];
        int l=mat.length+mat[0].length;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0)continue;
                int up=l;
                int left=l;
                if(i>0)up=d[i-1][j];
                if(j>0)left=d[i][j-1];
                d[i][j]=Math.min(up,left)+1;
            }
        }
        for(int i=mat.length-1;i>=0;i--){
            for(int j=mat[0].length-1;j>=0;j--){
                if(mat[i][j]==0)continue;
                int down=l;
                int right=l;
                if(i<mat.length-1)down=d[i+1][j];
                if(j<mat[0].length-1)right=d[i][j+1];
                d[i][j]=Math.min(Math.min(down,right)+1,d[i][j]);
            }
        }
        return d;

    }
    
}
// @lc code=end
