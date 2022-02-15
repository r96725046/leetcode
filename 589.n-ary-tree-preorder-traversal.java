/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
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
    public List<Integer> preorder(Node root) {
        Stack<Node> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();

        if(root==null)return list;
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            list.add(cur.val);
            for(int i=cur.children.size()-1;i>=0;i--)
                stack.push(cur.children.get(i));
        }
        return list;
    }
}
// @lc code=end

