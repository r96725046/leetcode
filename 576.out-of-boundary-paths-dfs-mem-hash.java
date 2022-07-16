/*
 * @lc app=leetcode id=576 lang=java
 *
 * [576] Out of Boundary Paths
 */

// @lc code=start
class Solution {
    int count=0;
    HashMap<String,Integer> map=new HashMap<>();
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return dfs(m,n,startRow,startColumn,maxMove);
        
    }

    public int dfs(int m,int n,int i,int j,int max){

        if(i<0||j<0||i>m-1||j>n-1)
            return 1;
        
        if(0==max)
            return 0;
        String key=i+","+j+","+max;
        if(map.containsKey(key))
            return map.get(key);
        int mod=1000000007;
        int ans=0;
        int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] d:dir){
            int r=i+d[0];
            int c=j+d[1];
            ans+=dfs(m,n,r,c,max-1)%mod;
            ans=ans%mod;
        }
        map.put(key,ans);
        return ans;
    }
}
// @lc code=end

