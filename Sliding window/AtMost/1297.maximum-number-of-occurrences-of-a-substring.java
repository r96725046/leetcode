/*
 * @lc app=leetcode id=1297 lang=java
 *
 * [1297] Maximum Number of Occurrences of a Substring
 */

// @lc code=start
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        int[] freq=new int[26];

        int start=0;
        int count=0;
        int res;
        HashMap<String,Integer> map=new HashMap<>();
        int max=0;

        for(int i=0;i<s.length();i++){

            int c=s.charAt(i)-'a';
            if(freq[c]==0)
                count++;
            freq[c]++;
            while(count>maxLetters||i-start+1>minSize){
                c=s.charAt(start)-'a';
                freq[c]--;
                if(freq[c]==0)
                    count--;
                start++;
            }
            if(i-start+1==minSize){
                String str=s.substring(start,i+1);
                if(!map.containsKey(str))
                    map.put(str,0);
                map.put(str,map.get(str)+1);
                max=Math.max(map.get(str),max);
            }
        }

        return max;

    }
}
// @lc code=end

