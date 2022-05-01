/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead=new HashSet<>();
        HashSet<String> visited=new HashSet<>();
        for(String s:deadends)
            dead.add(s);
        Queue<String> q=new LinkedList<>();
        visited.add("0000");
        q.offer("0000");
        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String s=q.poll();
                if(dead.contains(s))continue;
                if(s.equals(target))return step;
                
                for(int j=0;j<s.length();j++){
                    //up
                    char c=s.charAt(j);
                    String up=s.substring(0,j) + (c=='9'?0:(c-'0'+1)) +s.substring(j+1);
                    if(!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    //down
                    String down=s.substring(0,j) + (c=='0'?9:(c-'0'-1)) +s.substring(j+1);
                    if(!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }

        return -1;
    }
}
// @lc code=end

