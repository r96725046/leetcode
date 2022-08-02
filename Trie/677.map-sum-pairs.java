/*
 * @lc app=leetcode id=677 lang=java
 *
 * [677] Map Sum Pairs
 */

// @lc code=start
class MapSum {
    class Node{
        int sum=0;
        boolean isWord=false;
        Node[] nodes;
        public Node(){
            this.nodes=new Node[26];
        }

    }
    Node root;
    HashMap<String,Integer> map;
    public MapSum() {
        root=new Node();
        map=new HashMap<>();
    }
    
    public void insert(String key, int val) {
        Node cur=root;
        for(int i=0;i<key.length();i++){
            int v=key.charAt(i)-'a';
            if(cur.nodes[v]==null)
                cur.nodes[v]=new Node();
            cur=cur.nodes[v];
            if(map.containsKey(key))
                cur.sum-=map.get(key);
            cur.sum+=val;
        }
        cur.isWord=true;
        map.put(key,val);
    }
    
    public int sum(String prefix) {
        Node cur=root;
        for(int i=0;i<prefix.length();i++){
            int v=prefix.charAt(i)-'a';
            if(cur.nodes[v]==null)
                return 0;
            cur=cur.nodes[v];
        }
        return cur.sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end

