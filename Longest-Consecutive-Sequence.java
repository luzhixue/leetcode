public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int maxLen =  (num == null || num.length == 0)?0:1;
        for(int val:num){
            if(map.containsKey(val)) continue;
            map.put(val,1);
            if(map.containsKey(val-1))//there is a range ends at val-1
                maxLen = Math.max(maxLen, merge(map,val-1,val));
            if(map.containsKey(val+1))
                maxLen = Math.max(maxLen, merge(map,val,val+1));
        }
        return maxLen;
    }
    
    private int merge(HashMap<Integer,Integer> map, int leftRange, int rightRange){
        int leftVal = leftRange - map.get(leftRange) + 1;
        int rightVal = rightRange + map.get(rightRange) -1;
        int newRangeLen = map.get(leftRange) + map.get(rightRange);
        map.put(leftVal, newRangeLen);
        map.put(rightVal, newRangeLen);
        return newRangeLen;
    }
}
