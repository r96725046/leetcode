/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {
    //1.PriorityQueue even->max
    //2.max 1 > max   > max     > max 1 > max 3 1 > max 1   
    //  min     min 1   min 1 2   min 2   min 2     min 2 3
    
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    boolean even=true;
    /** initialize your data structure here. */
    public MedianFinder() {
        max=new PriorityQueue<>((x,y)->Integer.compare(y,x));
        min=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
       if(even)
       {
           max.offer(num);
           min.offer(max.poll());
       }else{
           min.offer(num);
           max.offer(min.poll());
       }
       even=!even;
    }
    
    public double findMedian() {
        if(max.size()==min.size())
            return (double)max.peek()/2+(double)min.peek()/2;
        else
            return (double)min.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

