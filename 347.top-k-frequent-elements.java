/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Node{
    int count=0;
    int key=0;
    public Node(){

    }
    public Node(int k,int c){
        key=k;
        count=c;
    }

}
class Solution {
    // ****
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null)return nums;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        Node[] arr=new Node[map.size()];
        int j=0;
        for(int key:map.keySet())
        {
            arr[j]=new Node(key,map.get(key));
            j++;
        }
        select(arr,0,arr.length-1,k);
       
        int[] res=new int[k];
        for(int i=0;i<k;i++)
            res[i]=arr[i].key;

        return res;
    }   
    //https://shubo.io/quick-sort/
    public void select(Node[] arr,int l,int r,int k){
        
        if(l==r){
            return ;
        }
        int p=arr[r].count;
        int index=l;
        for(int i=l;i<r;i++){    
            if(arr[i].count>p){
               swap(arr,i,index);
                index++;
            }
        }
        //Make sure all left items grater than p
        swap(arr,index,r);
        if(index==k-1)
            return;
        else if(index<k)
            select(arr,index+1,r,k);  
        else
            select(arr,l,index-1,k);
        
    }
    public void swap(Node[] arr,int l,int r){
        Node tmp=arr[l];
        arr[l]=arr[r];
        arr[r]=tmp;
    }
}
// @lc code=end

