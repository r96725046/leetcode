/*
 * @lc app=leetcode id=2024 lang=java
 *
 * [2024] Maximize the Confusion of an Exam
 */

// @lc code=start
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
      return Math.max(cal(answerKey,k,'T'),cal(answerKey,k,'F'));
    }
    public int cal(String answerKey, int k,char c){
        int freq=0;
        int start=0;
        int res=0;
        for(int i=0;i<answerKey.length();i++){
            if(answerKey.charAt(i)==c)
                freq++;
            while(freq>k){
                if(answerKey.charAt(start)==c)
                    freq--;
                start++;
            }
            res=Math.max(res,i-start+1);
        }
        return res;
    }
}
// @lc code=end

