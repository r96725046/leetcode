/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty()&&nums2[i]>nums2[stack.peek()]){
                int tmp=stack.pop();
                map.put(nums2[tmp],nums2[i]);
            }
            stack.push(i);
        }
        int[] res=new int[nums1.length];
        for(int i=0;i<res.length;i++)
        {
            if(map.containsKey(nums1[i]))
                res[i]=map.get(nums1[i]);
            else
                res[i]=-1;
        }
        return res;
    }
}
// @lc code=end

