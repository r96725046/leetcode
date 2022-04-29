/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            if(carry==1)digits[i]++;    
            if(digits[i]/10==1){
                carry=1;
                digits[i]%=10;
            }else{
                carry=0;
            }
        }
        
        if(carry==0)return digits;
        int[] res=new int[digits.length+1];
        res[0]=1;
        for(int i=0;i<digits.length;i++){
            res[i+1]=digits[i];
            
        }
        return res;
    }
}
// @lc code=end

