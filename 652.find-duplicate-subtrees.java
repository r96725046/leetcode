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
    HashMap<String,Integer> sid=new HashMap<>();
    HashMap<Integer,Integer> count=new HashMap<>();
    List<TreeNode> res=new ArrayList<>();
    int id=0;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traversal(root);
        return res;
    }
    private int traversal(TreeNode root){

        if(root==null) return 0;
        String key=root.val+"#"+traversal(root.left)+"#"+traversal(root.right);    
        if(!sid.containsKey(key))
        {
            id++;
            sid.put(key,id);
            count.put(id,1);
        }else{
            int curId=sid.get(key);
            count.put(curId,count.get(curId)+1);
            if(count.get(curId)==2)
                res.add(root);
            return curId;
        }
        return id;
    }
}
// @lc code=end

