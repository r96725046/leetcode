/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
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
class Solution {
    // 1.find target and ruturn distance
    // Not found -1
    // 2.in the begining of dfs
    //     if(map.containsKey(root))length=map.get(root);
    HashMap<TreeNode,Integer> map=new HashMap<>();
    List<Integer> res=new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        find(root,target);
        dfs(root,k,0);
        return res;
    }
    
    public int find(TreeNode root, TreeNode target){

        if(root==null)return -1;
        if(root.equals(target))
        {
            map.put(root,0);            
            return 0;
        }

        int left=find(root.left,target);
        int right=find(root.right,target);
        if(left>=0){
            map.put(root,left+1);
            return left+1;
        }
        if(right>=0){
            map.put(root,right+1);
            return right+1;
        }
        return -1;

    }
    public void dfs(TreeNode root,int k,int length){

        if(root==null)return;
        if(map.containsKey(root))length=map.get(root);
        if(length==k)res.add(root.val);
        dfs(root.left,k,length+1);
        dfs(root.right,k,length+1);
    }
}
// @lc code=end

