/*
 * @lc app=leetcode id=1079 lang=java
 *
 * [1079] Letter Tile Possibilities
 */

// @lc code=start
class Solution {
    int count;
   
    public int numTilePossibilities(String tiles) {
        
        char[] arr=new char[26];
        for(int i=0;i<tiles.length();i++){
            arr[tiles.charAt(i)-'A']++;
        }
        dfs(arr);
        return count;
    }
    private void dfs(char[] arr){
        for(int i=0;i<arr.length;i++){
           if(arr[i]==0)continue;
           arr[i]--;
           dfs(arr);
           arr[i]++;
           count++;
        }
    }
}
// @lc code=end

