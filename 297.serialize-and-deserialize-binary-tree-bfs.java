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
    // bfs - queue
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder sb =new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append("#").append(",");
                continue;
            }
            sb.append(node.val+",");
            q.offer(node.left);
            q.offer(node.right);

        }
        
        return sb.toString();

    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")return null;
        Queue<TreeNode> q=new LinkedList<>();
        String[] arr=data.split(",");
        TreeNode head=new TreeNode(Integer.valueOf(arr[0]));
        q.offer(head);
   
        for(int i=1;i<arr.length;i++){
            TreeNode parent=q.poll();
            if(!arr[i].equals("#")){
                parent.left=new TreeNode(Integer.valueOf(arr[i]));
                q.offer(parent.left);
            }
            i++;
            if(!arr[i].equals("#")){
                parent.right=new TreeNode(Integer.valueOf(arr[i]));
                q.offer(parent.right);
            }
        }

        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

