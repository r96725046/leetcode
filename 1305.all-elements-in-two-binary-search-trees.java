/*
 * @lc app=leetcode id=1305 lang=java
 *
 * [1305] All Elements in Two Binary Search Trees
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
   
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> list1=dfs(root1,new ArrayList<>());
        List<Integer> list2=dfs(root2,new ArrayList<>());

        List<Integer> res=new ArrayList<>();

        int i=0;
        int j=0;
        while(i<list1.size()&&j<list2.size()){

            if(list1.get(i)>list2.get(j)){
                res.add(list2.get(j));
                j++;
            }else{
                res.add(list1.get(i));
                i++;
            }
        }
        List<Integer> remains;
        int k;
        if(i<list1.size()){
            remains=list1;
            k=i;
        }else{
            remains=list2;
            k=j;
        }
        while(k<remains.size()){
            res.add(remains.get(k));
            k++;
        }
        return res;
    }
    private List<Integer> dfs(TreeNode root,List<Integer> list){
        if(root==null)return list;

        list=dfs(root.left,list);
        list.add(root.val);
        return dfs(root.right,list);
    }
    
}
// @lc code=end

