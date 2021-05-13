/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        int[] arr=new int[matrix[0].length];
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0')
                    arr[j]=0;
                else
                    arr[j]+=1;
            }
            max=Math.max(max,maxHistgram(arr));

        }
        return max;    
    }
    public int maxHistgram(int[] arr){

        if(arr.length==1)
            return arr[0];
        int[] left=new int[arr.length];
        int[] right=new int[arr.length];
        left[0]=-1;
        right[arr.length-1]=arr.length;

        for(int i=1;i<arr.length;i++){
            int p=i-1;
            while(p>=0&& arr[p]>=arr[i]){
                p=left[p];
            }
            left[i]=p;
        }
        for(int i=arr.length-2;i>=0;i--){
            int p=i+1;
            while(p<arr.length&&arr[p]>=arr[i]){
                p=right[p];
            }
            right[i]=p;
        }
        
        int max=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]*(right[i]-left[i]-1));
        }
        return max;
    }

}
// @lc code=end

