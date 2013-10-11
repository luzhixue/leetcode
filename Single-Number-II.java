public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int result = 0;
        for(int i = 0; i < Integer.SIZE; i++){
            int count = 0;
            int mask = 1 << i;
            for(int j = 0; j < A.length; j++){
                if((mask & A[j]) != 0)
                    ++count;
            }
            count = count%3;
            count = count << i;
            result = result ^ count;
        }
        return result;
    }
}
