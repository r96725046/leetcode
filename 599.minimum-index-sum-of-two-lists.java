/*
 * @lc app=leetcode id=599 lang=java
 *
 * [599] Minimum Index Sum of Two Lists
 */

// @lc code=start
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
         HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int min=Integer.MAX_VALUE;
        List<String> res=new ArrayList<>();
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                if(map.get(list2[i])+i<=min){
                    if(map.get(list2[i])+i<min)
                        res=new ArrayList<>();
                    min=map.get(list2[i])+i;
                    res.add(list2[i]);
                }
            }
            
        }
        String[] arr=new String[res.size()];
        for(int i=0;i<arr.length;i++)
            arr[i]=res.get(i);
        return arr;
    }
}
// @lc code=end

