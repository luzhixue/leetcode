//First sort intervals by their start point (then by end point);
//use ArrayList<Interval> ret    to save finished merges. 
//if the current interval does not overlap with the next interval, we put it to ret
//since we sort by start point, so our later operation will not impact earlier result

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                if(a.start != b.start) return a.start-b.start;
                else return a.end-b.end;
            }
        });
        ArrayList<Interval> ret = new ArrayList<Interval>();
        int curIdx = 0;
        Interval curInterval = intervals.get(curIdx++);
        while(curInterval != null){
            while(curIdx < intervals.size() && intervals.get(curIdx).start <= curInterval.end){//find an overlap
                curInterval = mergeInterval(curInterval, intervals.get(curIdx));    
                ++curIdx;
            }
            ret.add(curInterval);
            curInterval = ((curIdx < intervals.size())?intervals.get(curIdx++):null);
        }
        return ret;
    }
    
    //merge two sorted interval;
    private Interval mergeInterval(Interval front, Interval back){
        front.end = Math.max(front.end, back.end);
        return front;
    }
}
