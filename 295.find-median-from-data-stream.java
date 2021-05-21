/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    /** initialize your data structure here. */
    public MedianFinder() {
        max=new PriorityQueue<>((x,y)->Integer.compare(y,x));
        min=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(min.size()>max.size())
            max.offer(min.poll());
    }
    
    public double findMedian() {
        
        if(max.size()==min.size())
            return (double)max.peek()/2+(double)min.peek()/2;
        else
            return (double)max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

