/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> res =new ArrayList<List<Integer>>();
        if(root==null) return res;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int l=q.size();
            List<Integer> lv=new ArrayList<>();
            for(int i=0;i<l;i++){
                Node node=q.poll();
                List<Node> ch=node.children;
                lv.add(node.val);
                for(int j=0;j<ch.size();j++)
                    q.offer(ch.get(j));
            }
            res.add(lv);
        }
        return res;
    }
}
// @lc code=end

