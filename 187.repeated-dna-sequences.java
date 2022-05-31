/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set=new HashSet<>();
        HashSet<String> repeated=new HashSet<>();

        for(int i=0;i+9<s.length();i++){
            String str=s.substring(i,i+10);
            if(set.contains(str)){
                repeated.add(str);
            }else{
                set.add(str);
            }
        }
        return new ArrayList<>(repeated);
    }
}
// @lc code=end

