/*
 * @lc app=leetcode id=950 lang=java
 *
 * [950] Reveal Cards In Increasing Order
 */

// @lc code=start
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q=new LinkedList<>();
        Arrays.sort(deck);
        for(int i=deck.length-1;i>=0;i--){
            if(!q.isEmpty()){
                q.offer(q.poll());
            }
            q.offer(deck[i]);
        }
        int[] res=new int[deck.length];
        for(int i=res.length-1;i>=0;i--){
            res[i]=q.poll();
        }
        return res;
    }
}
// @lc code=end

