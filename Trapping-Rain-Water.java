// 1. Mark it as left and move forward current to next bar.
// 2. If current < left, calculate the difference, store it in a temporary sum, and move forward to next bar;
// 3. Otherwise, add the temporary sum to the total volume, and continue to step 1.
// But this will fail the case of [2, 1, 0, 1], where the expected result is 1 but 0 will be returned from the above 
// procedure. A fix is when we hit the end of the given array and if left is not current, go backwards to calculate the volume until we hit left.

public class Solution {
    public int trap(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A == null || A.length == 0) return 0;
        int left = 0, curIdx = 0;
        //move left boundary to the fist positive height
        while(curIdx < A.length && A[curIdx] <= 0){
            ++curIdx;
        }
        if(curIdx == A.length-1) return 0;
        left = curIdx;
        int capacity = 0, tmp = 0;
        for(curIdx = curIdx+1; curIdx < A.length; curIdx++){
            if(A[curIdx] < A[left]){
                tmp += A[left]-A[curIdx];
                continue;
            }
            else{//find the right bound
                capacity += tmp;
                left = curIdx;
                tmp = 0;
            }
        }
        
        if(left <= A.length-1){//need to use the right part
            int[] subA = new int[A.length-left];
            for(int i = 0; i < subA.length; i++){
                subA[i] = A[A.length-1-i];
            }
            return capacity + trap(subA);
        }
        return capacity;
        
    }
}
