/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] arr=new int[52];

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c<'a'||c>'z')
                arr[c-'A'+26]++;
            else
                arr[c-'a']++;
        }
        int odd=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%2!=0)odd++;
        }

        return odd>0?s.length()-odd+1:s.length();
    }
}
// @lc code=end

