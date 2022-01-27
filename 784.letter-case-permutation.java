/*
 * @lc app=leetcode id=784 lang=java
 *
 * [784] Letter Case Permutation
 */

// @lc code=start
class Solution {
    List<String> list=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        char[] arr=s.toCharArray();
        backtrack(arr,0);
        return list;
    }
    public void backtrack(char[] s,int index){
        if(index>=s.length){
            list.add(new String(s));
            return;
        }
        if(s[index]>='0'&&s[index]<='9'){
            backtrack(s,index+1);
            return;
        }
        char c=s[index];
        int n=c-'a'<0||c-'a'>25?c-'A':c-'a';

        s[index]=(char)(n+'a');
        backtrack(s,index+1);
        s[index]=(char)(n+'A');
        backtrack(s,index+1);
    }
}
// @lc code=end

