/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    // ***
    // https://leetcode.wang/leetCode-52-N-QueensII.html
    // 1.col+row 0~2n-2 
    // 2.row-col -2~2 => row-col + n  1~2n-1 
    // 3.cols
    //      col         col
    // row   0 1 2 row   0  1  2 
    //     0 0 1 2     0 0 -1 -2
    //     1 1 2 3     1 1  0 -1
    //     2 2 3 4     2 2  1  0
    boolean[] cols;
    boolean[] d1;
    boolean[] d2;
    int count=0;
    public int totalNQueens(int n) {
        cols=new boolean[n];
        d1=new boolean[2*n];
        d2=new boolean[2*n];
        traversal(0,n);
        return count;
    }
    private void traversal(int row,int n){
        if(row==n){
            count++;
            return;
        }
        for(int j=0;j<n;j++){
            if(cols[j]||d1[row+j]||d2[row-j+n])
                continue;
            cols[j]=true;
            d1[row+j]=true;
            d2[row-j+n]=true;
            traversal(row+1,n);
            cols[j]=false;
            d1[row+j]=false;
            d2[row-j+n]=false;
        }
    }
}
// @lc code=end
