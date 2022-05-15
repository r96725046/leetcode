/*
 * @lc app=leetcode id=686 lang=java
 *
 * [686] Repeated String Match
 */

// @lc code=start
class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        int count=0;
        StringBuilder sb =new StringBuilder();
        while(sb.length()<b.length()){
            sb.append(a);
            count++;
        }
        if(sb.toString().contains(b))return count;
        sb.append(a);
        return sb.toString().contains(b)?count+1:-1;
    }
    
}
// @lc code=end

