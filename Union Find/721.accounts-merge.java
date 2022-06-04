/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String,Integer> map=new HashMap<>();
        UF uf=new UF(accounts.size());
        // Name id parent
        // John 0
        // John 1-> 0
        // Mary 2
        // John 3
        for(int i=0;i<accounts.size();i++){
            List<String> list=accounts.get(i);
            for(int j=1;j<list.size();j++){
                String account=list.get(j);
                if(!map.containsKey(account))
                {
                    map.put(account,i);
                }else{//*****
                    uf.union(i,map.get(account));
                }
            }
        }   
        HashMap<Integer,List<String>> items=new HashMap<>();
        for(String s:map.keySet()){
           int id=map.get(s);
           int index=uf.find(id);
            if(!items.containsKey(index))
                items.put(index, new ArrayList<String>());
            items.get(index).add(s);
        }
        List<List<String>> res=new ArrayList<>();

        for(int i:items.keySet()){
            String name=accounts.get(i).get(0);
            List<String> list=items.get(i);
            Collections.sort(list);
            list.add(0,name);
            res.add(list);
        }
        return res;
    }
}
// @lc code=end

