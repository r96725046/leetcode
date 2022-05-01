/*
 * @lc app=leetcode id=729 lang=java
 *
 * [729] My Calendar I
 */

// @lc code=start
class MyCalendar {
    // floorKey
    // ceilingKey
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map=new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer fkey=map.floorKey(start);
        //End > Start
        if(fkey!=null&&map.get(fkey)>start) return false;
        Integer ckey=map.ceilingKey(start);
        //Start < End
        if(ckey!=null&&ckey<end)return false;
        map.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

