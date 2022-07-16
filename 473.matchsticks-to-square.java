/*
 * @lc app=leetcode id=473 lang=java
 *
 * [473] Matchsticks to Square
 */

// @lc code=start
class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks==null||matchsticks.length<4)
            return false;
        int sum=0;
        
        for(int i=0;i<matchsticks.length;i++)
            sum+=matchsticks[i];

        if(sum%4!=0)
            return false;
        Arrays.sort(matchsticks);
        int num=sum/4;
        return dfs(matchsticks,new int[]{num,num,num,num},matchsticks.length-1);
    }
    public boolean dfs(int[] arr,int[] sums,int index) {
        if (index <0) {
    	    if (sums[0] == 0 && sums[1] == 0 && sums[2] == 0) {
    		return true;
    	    }
    	    return false;
    	}

        for(int i=0;i<sums.length;i++){
            if(sums[i]<arr[index]) continue;
            sums[i]-=arr[index];
            if(dfs(arr,sums,index-1))return true;
            sums[i]+=arr[index];
        }
        return false;
    }
}
// @lc code=end

