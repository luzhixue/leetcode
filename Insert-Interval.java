//locate the first part that do not overlap with the newInterval
//locate the last part that do not overlap with the newInterval
//add first part to result
//merge all the part in-between first---last with newInterval, add to result
//add last part to array

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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int preIdx = 0, nextIdx = 0;//the index of first and last non-overlap intervalser
        while(preIdx < intervals.size()){
            if(intervals.get(preIdx).end < newInterval.start)
                ++preIdx;
            else
                break;
        }
        --preIdx;//0....preIdx intervals do not overlap
        nextIdx = preIdx + 1;
        while(nextIdx < intervals.size()){
            if(intervals.get(nextIdx).start <= newInterval.end)
                ++nextIdx;
            else
                break;
        }
        //nextIdx...intervals.size() do not overlap
        ArrayList<Interval> ret = new ArrayList<Interval>();
        for(int i = 0; i <= preIdx; i++)//add previous non-overlap intervals
            ret.add(intervals.get(i));
        newInterval = mergeInterval(intervals, preIdx+1, nextIdx-1, newInterval);//merge all intervals inbetween
        ret.add(newInterval);
        for(int i = nextIdx; i < intervals.size(); i++)
            ret.add(intervals.get(i));
        return ret;
    }
    
    private Interval mergeInterval(ArrayList<Interval> intervals, int startIdx, int endIdx, Interval newInterval){
        if(startIdx >= intervals.size()) return newInterval;//nothing to merge
        for(int i = startIdx; i <= Math.min(intervals.size()-1, endIdx); i++){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
        }
        return newInterval;
    }
}
