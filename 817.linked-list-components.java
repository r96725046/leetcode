/*
 * @lc app=leetcode id=817 lang=java
 *
 * [817] Linked List Components
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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
            set.add(nums[i]);
        int count=0;
        boolean connected=false;
        while(head!=null){
            if(set.contains(head.val)){
                if(!connected){
                    count++;
                    connected=true;
                }
            }else
                connected=false;
            head=head.next;
        }
        return count;
    }
}
// @lc code=end

