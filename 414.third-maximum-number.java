/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
      HashSet<Integer> set=new HashSet<>();
        for(int v:nums)
            set.add(v);
        int i=0;
        int[] res=new int[set.size()];
        for(int v:set)
            res[i++]=v;
        if(res.length<3)
        {
            int max=nums[0];
            for(int v:res)
                max=Math.max(v,max);
            return max;
        }
        quickSelect(res,0,res.length-1,3);
        return res[2];
        
    }
    private void quickSelect(int[] nums,int l,int r,int k){
        int p=nums[r];
        int index=l;
        for(int i=l;i<r;i++){
            
            if(nums[i]>p){
                int tmp=nums[index];
                nums[index]=nums[i];
                nums[i]=tmp;
                index++;
            }
           
        }
        int tmp=nums[index];
        nums[index]=nums[r];
        nums[r]=tmp;
        if(index==k-1)
            return;
        else if(index>k-1)
            quickSelect(nums,l,index-1,k);
        else
            quickSelect(nums,index+1,r,k);
            
    }
}
// @lc code=end

