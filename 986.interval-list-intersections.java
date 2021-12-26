/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int i=0;
        int j=0;
        List<int[]> list=new ArrayList<>();
        while(i<firstList.length&&j<secondList.length){

            int start=Math.max(firstList[i][0],secondList[j][0]);
            int end=Math.min(firstList[i][1],secondList[j][1]);

            if(start<=end)
                list.add(new int[]{start,end});

            if(end==firstList[i][1])i++;
            if(end==secondList[j][1])j++;
           
        }

        int[][] res=new int[list.size()][2];
        for(int k=0;k<res.length;k++)
            res[k]=list.get(k);
        return res;

    }
}
// @lc code=end

