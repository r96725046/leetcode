/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    // ***
    //row+1 col1 for (0,0,0,0)
    //1.+sum[i][j-1]
    //2.+sum[i-1][j]
    // 1 2  1 3  1 3
    // 3 4  3 7  4 10
    //4-2-3+1
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        sum=new int[matrix.length+1][matrix[0].length+1];


        for(int i=1;i<sum.length;i++){
            for(int j=1;j<sum[0].length;j++){
                sum[i][j]=matrix[i-1][j-1]+sum[i][j-1];
            }
        }

        for(int i=1;i<sum.length;i++){
            for(int j=1;j<sum[0].length;j++)
                sum[i][j]+=sum[i-1][j];
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1]-sum[row1][col2+1]-sum[row2+1][col1]+sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

