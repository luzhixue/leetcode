public class Solution {
    public void sortColors(int[] A) {
        if(A == null || A.length <= 1) return;
        int nextRedIdx = 0, nextBlueIdx = A.length - 1;
        for(int i = 0; i <= nextBlueIdx; i++){
            if(A[i] == 0){//red
                if(i == nextRedIdx)
                    continue;
                else
                    swap(A, nextRedIdx++, i--);
                    //--i;//if we are doing a a swap, then we should recheck the new value
                    //++nextRedIdx;
            }
            else if(A[i] == 2){//blue
                if(i == nextBlueIdx)
                    continue;
                else
                    swap(A, nextBlueIdx--, i--);
                    //--i;//if we are doing a swap, then we should recheck the new value
                    //--nextBlueIdx;
            }
            //else, it is a white, we do nothing    
        }
    }
    
    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
