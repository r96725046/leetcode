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
    // 1.hashmap save new nodes, queue save old nodes
    // 1
    public Node cloneGraph(Node node) {
        if(node==null)return node;
        HashMap<Integer,Node> map=new HashMap<>();
        Queue<Node> q=new LinkedList<>();

        q.offer(node);
        Node root=new Node(node.val);
        map.put(node.val,root);
        while(!q.isEmpty()){

            Node cur=q.poll();
            Node head=map.get(cur.val);
            List<Node> list=cur.neighbors;
            for(Node sub:list){

                Node newNode;
                if(map.containsKey(sub.val)){
                    newNode=map.get(sub.val);
                }else{
                    newNode=new Node(sub.val);
                    map.put(sub.val,newNode);
                    q.offer(sub);
                }
                head.neighbors.add(newNode);
            }

        }
        return root;
    }
   
}
// @lc code=end

