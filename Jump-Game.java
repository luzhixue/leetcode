//maintain a maximum idx we can reach so far, iterate A[0] to A[n], if A[i] not 0, update maximum, else check if we can skip this 0
public class Solution {
    public boolean canJump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A == null || A.length == 0) return true;
        int curMax = 0;
        for(int i = 0; i < A.length - 1; i++){
            if(A[i] > 0){
                curMax = Math.max(curMax, i + A[i]);//A[i] is not 0, update the maxIdx we can reach
            }
            else if(curMax <= i){//A[i] is 0, not able to jump over i
                return false;
            }
        }
        return true;
    }
}



//locate 0 in the array (0.....N), for each 0, go back and check if a number if large enough to jump the gap, O(N^2)
public class Solution {
    public boolean canJump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A == null || A.length == 0) return true;
        int zeroIdx = 0;
        while(zeroIdx < A.length - 1){
            if(A[zeroIdx] == 0){
                boolean jumpOver = false;
                for(int preIdx = zeroIdx - 1; preIdx >=0; preIdx--){
                    if(A[preIdx] + preIdx > zeroIdx){
                        jumpOver = true;
                        break;
                    }
                }
                if(!jumpOver) return false;
            }
            ++zeroIdx;
        }
        return true;
    }
}
