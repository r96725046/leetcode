/*
 * @lc app=leetcode id=895 lang=java
 *
 * [895] Maximum Frequency Stack
 */

// @lc code=start
class FreqStack {
    HashMap<Integer,Integer> count;
    HashMap<Integer,Stack<Integer>> group;
    int max=0;
    public FreqStack() {
        count=new HashMap<>();
        group=new HashMap<>();
    }

    public void push(int val) {
        if(!count.containsKey(val))
            count.put(val,0);
        count.put(val,count.get(val)+1);
        max=Math.max(max,count.get(val));
        int c=count.get(val);
        if(!group.containsKey(c))
            group.put(c,new Stack());
        group.get(c).push(val);

       
    }
    
    public int pop() {
        int res=group.get(max).pop();
        count.put(res,count.get(res)-1);
        if(group.get(max).size()==0)
            max--;
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
// @lc code=end

