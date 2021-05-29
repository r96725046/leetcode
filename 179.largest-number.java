/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        //1.Natural Sort String
        //2.0000 case
        String[] arr=new String[nums.length];
        for(int i=0;i<nums.length;i++)
            arr[i]=String.valueOf(nums[i]);

        Arrays.sort(arr,(x,y)->(y+x).compareTo((x+y)));
        StringBuilder sb=new StringBuilder();

        for(String n:arr){
            if(n.equals("0")&&sb.length()==0)
                continue;
            sb.append(n);
        }
        return sb.length()>0?sb.toString():"0";
    }
}
// @lc code=end

