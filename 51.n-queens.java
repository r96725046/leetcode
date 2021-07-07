/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    List<List<String>> res=new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        char[][] matrix=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                matrix[i][j]='.';
        traversal(0,matrix);
        return res;
    }

    private void traversal(int row,char[][] matrix){

        if(row==matrix.length){
            List<String> list=new ArrayList<>();
            for(int i=0;i<matrix.length;i++)
                list.add(new String(matrix[i]));
            res.add(list);
            return;
        }
        for(int j=0;j<matrix[0].length;j++){
            if(valid(matrix,row,j)){
                matrix[row][j]='Q';
                traversal(row+1,matrix);
                matrix[row][j]='.';
            }
        }    
    }
    private boolean valid(char[][] matrix,int row,int col){

        for(int i=0;i<row;i++)
            if(matrix[i][col]=='Q')return false;
        int i=row-1;
        int j=col-1;
        while(i>=0&&j>=0){
            if(matrix[i][j]=='Q')return false;
            i--;
            j--;
        }
        i=row-1;
        j=col+1;
        while(i>=0&&j<matrix[0].length){
            if(matrix[i][j]=='Q')return false;
            i--;
            j++;
        }
        return true;
    }

}
// @lc code=end

