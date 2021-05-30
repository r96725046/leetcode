/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // ***
    HashMap<Integer,Node> map=new HashMap<>();
    public Node cloneGraph(Node node) {
            if(node==null)return node;
            Queue<Node> q=new LinkedList<Node>();
            q.offer(node);
            
            Node root=new Node(node.val);
            map.put(node.val,root);
            
            while(!q.isEmpty()){

                Node head=q.poll();
                Node newHead=map.get(head.val);
                for(Node sub:head.neighbors)
                {   
                    Node n=null;
                    if(!map.containsKey(sub.val)){
                        q.offer(sub);
                        n=new Node(sub.val);        
                        map.put(sub.val,n);
                    }else{
                        n=map.get(sub.val);
                    }
                    // ***
                    newHead.neighbors.add(n);
                }

            }
            return root;
    }
}
// @lc code=end

