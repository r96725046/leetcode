/*
 * @lc app=leetcode id=449 lang=java
 *
 * [449] Serialize and Deserialize BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serializer(root,sb);
        return sb.toString();
    }
    private void serializer(TreeNode root,StringBuilder sb){
        if(root==null)return;
        sb.append(root.val).append(",");
        serializer(root.left,sb);
        serializer(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)return null;
        Queue<String> queue=new LinkedList<>();
        String[] values=data.split(",");
        for(String v:values)
            queue.offer(v);
        
        return deserializer(queue,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private TreeNode deserializer(Queue<String> queue,int lo,int hi){

        if(queue.isEmpty())return null;
        String s=queue.peek();
        int v=Integer.parseInt(s);
        if(v<lo||v>hi)return null;
        TreeNode node=new TreeNode(v);
        queue.poll();
        node.left=deserializer(queue,lo,v);
        node.right=deserializer(queue,v,hi);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end

