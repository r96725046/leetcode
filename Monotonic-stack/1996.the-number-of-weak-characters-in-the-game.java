/*
 * @lc app=leetcode id=1996 lang=java
 *
 * [1996] The Number of Weak Characters in the Game
 */

// @lc code=start
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (x,y)->x[0]!=y[0]?Integer.compare(x[0],y[0]):Integer.compare(y[1],x[1]));
        int count=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<properties.length;i++){  
            while(!stack.isEmpty()&&properties[stack.peek()][0]<properties[i][0]&&properties[stack.peek()][1]<properties[i][1]){
                stack.pop();
                count++;
            }
            stack.push(i);
        }
        return count;
    }
}
// @lc code=end
