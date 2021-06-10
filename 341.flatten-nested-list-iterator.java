/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    // ***
    // 1.!stack.isEmpty() && !stack.peek().isInteger()
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack=new Stack<>();
        enstack(nestedList);
    }
    private void enstack(List<NestedInteger> list){

        for(int i=list.size()-1;i>=0;i--)
            stack.push(list.get(i));

        while(!stack.isEmpty()&&!stack.peek().isInteger()){
            enstack(stack.pop().getList());
        }

    }

    @Override
    public Integer next() {
        if(!hasNext())
            return null;
        Integer res = stack.pop().getInteger();
        if (!stack.isEmpty() && !stack.peek().isInteger()) {
            enstack(stack.pop().getList());
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        if(stack.isEmpty())
            return false;

        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

