/*
 * @lc app=leetcode id=1019 lang=java
 *
 * [1019] Next Greater Node In Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode runner=head;
        int count=0;
        while(runner!=null){
            count++;
            runner=runner.next;
        }
        int[] res=new int[count]; 
        Stack<int[]> stack=new Stack<>();
        runner=head;
        for(int i=0;i<res.length;i++){
            res[i]=0;
            while(!stack.isEmpty()&&stack.peek()[1]<runner.val){
                res[stack.pop()[0]]=runner.val;
            }
            stack.push(new int[]{i,runner.val});
            runner=runner.next;
        }
        return res;

    }
}
// @lc code=end

