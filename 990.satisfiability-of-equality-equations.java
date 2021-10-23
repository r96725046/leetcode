/*
 * @lc app=leetcode id=990 lang=java
 *
 * [990] Satisfiability of Equality Equations
 */

// @lc code=start
class Solution {
    int[] parents=new int[26];
    public boolean equationsPossible(String[] equations) {

        for(int i=0;i<parents.length;i++)
            parents[i]=i;
        for(String eq:equations){
            if(eq.charAt(1)=='=')
                parents[find(eq.charAt(0)-'a')]=find(eq.charAt(3)-'a');
        }
        for(String eq:equations){
            if(eq.charAt(1)=='!'){
                if(find(eq.charAt(0)-'a')==find(eq.charAt(3)-'a'))
                    return false;
            }

        }
        return true;
    }
    public int find(int i){
        if(parents[i]==i)
            return i;
        else
            return find(parents[i]);
    }
}
// @lc code=end

