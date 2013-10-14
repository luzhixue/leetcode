public class Solution {
    public int searchInsert(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A.length == 0) return 0;
        int idx = 0;
        while(idx < A.length && A[idx] < target){
            ++idx;
        }
        return idx;
    }
}
