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
    // dfs prefix - queue 
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
        
        build(root.left,sb);
        build(root.right,sb);
        sb.append(root.val).append(",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Stack<String> stack=new Stack<>();
        String[] arr=data.split(",");
        for(String s:arr)
            stack.push(s);
        return buildTree(stack);
    }
    private TreeNode buildTree(Stack<String> stack){
       
        String s=stack.pop();
        if(s.equals("#"))
            return null;

        TreeNode node=new TreeNode(Integer.parseInt(s));
        node.right=buildTree(stack);
        node.left=buildTree(stack);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

