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


public class Solution {
    public int singleNumber(int[] A) {
        if(A == null || A.length%3 != 1) return -1;//can throw exception
        if(A.length == 1) return A[0];
        int one = 0, two = 0;
        for(int i = 0; i < A.length; i++){
            int nextOne = (~A[i] & one)|(A[i] & ~one & ~two);
            int nextTwo = (~A[i] & two)|(A[i] & one);
            one = nextOne;
            two = nextTwo;
        }
        return one;
    }
}
