/*
 * @lc app=leetcode id=919 lang=java
 *
 * [919] Complete Binary Tree Inserter
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    Queue<TreeNode> q=new LinkedList<>();
    TreeNode head;
    public CBTInserter(TreeNode root) {
        this.head=root;
        q.offer(root);
        while(true){
            TreeNode cur=q.peek();
            if(cur.right!=null){
                q.offer(cur.left);
                q.offer(cur.right);
                q.poll();    
            }else
                break;
            
        }
    }
    
    public int insert(int val) {
        TreeNode node=new TreeNode(val);

        TreeNode cur=q.peek();
        if(cur.left==null)
            cur.left=node;
        else{
            cur.right=node;
            q.offer(cur.left);
            q.offer(cur.right);
            q.poll();
        }
        return cur.val;
    }
    
    public TreeNode get_root() {
        return head;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
// @lc code=end

