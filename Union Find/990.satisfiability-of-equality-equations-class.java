/*
 * @lc app=leetcode id=990 lang=java
 *
 * [990] Satisfiability of Equality Equations
 */

// @lc code=start
class Solution {
    class UF{
        int[] parent;
        public UF(int n){
            parent=new int[n];
            for(int i=0;i<parent.length;i++)
                parent[i]=i;
        }
        public int find(int x){
            while(parent[x]!=x){
                x=parent[x];
            }
            return x;
        }
        public void union(int x,int y){
            int i=find(x);
            int j=find(y);
            if(i==j)
                return;
            parent[j]=i;
        }
    }
    public boolean equationsPossible(String[] equations) {
        UF uf=new UF(26);
        for(int i=0;i<equations.length;i++){
            String e=equations[i];
            if(e.charAt(1)=='='){
                uf.union(e.charAt(0)-'a',e.charAt(3)-'a');
            }
        }
        for(int i=0;i<equations.length;i++){
            String e=equations[i];
            if(e.charAt(1)=='!'){
                if(uf.find(e.charAt(0)-'a')==uf.find(e.charAt(3)-'a'))
                    return false;
            }
        }
        return true;
    }
}
// @lc code=end

