/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 */

// @lc code=start
class Solution {
    // (i+j)%2
    // j==col-1 and i==row-1 
    // i==0 and j==0
    public int[] findDiagonalOrder(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        List<Integer> list=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<row&&j<col){
            list.add(mat[i][j]);
            if((i+j)%2==0){
                if(j==col-1)i++;
                else if(i==0)j++;
                else{
                    i--;
                    j++;
                }
            }else{
                if(i==row-1)j++;
                else if(j==0)i++;
                else{
                    i++;
                    j--;
                }
            }
        }
        int[] res=new int[list.size()];
        for(int k=0;k<list.size();k++)
            res[k]=list.get(k);
        return res;
    }
}
// @lc code=end

