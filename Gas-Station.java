public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length != cost.length) return -1;
        int start = 0, n = gas.length;
        while(start < n){
            int cur = start, remain = 0;
            boolean started = false;
            while((cur != start || !started) && remain >= 0){
                remain = gas[cur] - cost[cur] + remain;
                if(!started)
                    started = true;
                cur = (cur+1)%n;
            }
            if(remain < 0)
                start = (cur>start)?cur:cur+n; //move the start to the current location
            else if(cur == start)
                return start;
        }
        return -1;
    }
}
