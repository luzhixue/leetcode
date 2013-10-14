//matrix is sorted, so just do a binary search
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int minIdx = 0, maxIdx = matrix.length * matrix[0].length - 1;
        int n = matrix[0].length;
        while(minIdx <= maxIdx){
            int middleIdx = (minIdx + maxIdx)/2;
            if(matrix[rowNum(n, middleIdx)][colNum(n, middleIdx)] == target)
                return true;
            if(matrix[rowNum(n, middleIdx)][colNum(n, middleIdx)] < target)
                minIdx = middleIdx + 1;
            else
                maxIdx = middleIdx - 1;
        }
        return false;
    }
    
    
    
    private int rowNum(int n, int linearIdx){
        return linearIdx/n;
    }
    private int colNum(int n, int linearIdx){
        return linearIdx%n;
    }
}
