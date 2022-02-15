/*
 * @lc app=leetcode id=559 lang=java
 *
 * [559] Maximum Depth of N-ary Tree
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
    public int maxDepth(Node root) {
        if(root==null)return 0;
        if(root.children==null)return 1;
        int dep=0;
        List<Node> ch=root.children;
        for(Node child:root.children)
            dep=Math.max(maxDepth(child),dep);
        return dep+1;
    }
}
// @lc code=end

