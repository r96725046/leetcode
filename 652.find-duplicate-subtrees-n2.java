/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
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
class Solution {
    List<TreeNode> list=new ArrayList<>();
    HashMap<String,Integer> map=new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traversal(root);
        return list;
    }
    private String traversal(TreeNode root){
        if(root==null)return "";
        String key= root.val+"#"+traversal(root.left)+"#"+traversal(root.right);
        
        if(map.containsKey(key)){
            map.put(key,map.get(key)+1);
            if(map.get(key)==2)
                list.add(root);    
        }else{
            map.put(key,1); 
        }
        return key;
    }
}
// @lc code=end

