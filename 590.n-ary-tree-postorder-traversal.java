/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
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
    public List<Integer> postorder(Node root) {
        Stack<Node> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        if(root==null)return list;
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            list.add(0,cur.val);
            for(int i=0;i<cur.children.size();i++)
                stack.push(cur.children.get(i));
        }
        return list;
    }
}
// @lc code=end

