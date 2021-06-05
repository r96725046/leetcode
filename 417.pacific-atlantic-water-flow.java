/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    // ***
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] h=heights;
        boolean[][] v=new boolean[h.length][h[0].length];
       
        
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        for(int i=0;i<h.length;i++){

            for(int j=0;j<h[0].length;j++)
            {
                if(dfs(v,h,Integer.MAX_VALUE,i,j,true)&&
                   dfs(v,h,Integer.MAX_VALUE,i,j,false))
                {
                    List<Integer> ans=new ArrayList<Integer>();
                    ans.add(i);
                    ans.add(j);
                    list.add(ans);
                }
            }
        }
        return list;
    }
    public boolean dfs(boolean[][] visited,int[][] h,int pre,int i,int j,boolean p){
        
        if(i<0||j<0){
            if(p)
                return true;
            else
                return false;
        }
        if(i>=h.length||j>=h[0].length){
            if(p)
                return false;
            else    
                return true;
        }
        if(visited[i][j]==true||pre<h[i][j])
            return false;
        visited[i][j]=true;

        boolean res= dfs(visited,h,h[i][j],i+1,j,p)||
               dfs(visited,h,h[i][j],i,j+1,p)||
               dfs(visited,h,h[i][j],i-1,j,p)||
               dfs(visited,h,h[i][j],i,j-1,p);
        
        visited[i][j]=false;
        return res;
    }
    
}
// @lc code=end

