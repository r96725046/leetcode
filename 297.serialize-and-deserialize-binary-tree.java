/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
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
import java.util.*;
public class Codec {
    // ***
    // dfs - queue 
    // left and right
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb=new StringBuilder();
        build(root,sb);
        return sb.toString();

    }
    private void build(TreeNode root, StringBuilder sb){

        if(root==null){
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        build(root.left,sb);
        build(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q=new LinkedList<>();
        String[] arr=data.split(",");
        for(String s:arr)
            q.offer(s);
        return buildTree(q);
    }
    private TreeNode buildTree(Queue<String> q){
        String s=q.poll();
        if(s.equals("#"))
            return null;

        TreeNode node=new TreeNode(Integer.valueOf(s));
        node.left=buildTree(q);
        node.right=buildTree(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

