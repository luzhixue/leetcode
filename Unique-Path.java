//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//How many possible unique paths are there?

//1. fill the last row and the last column
//2. fill row n-2 to 0 from right to left 
//(the idea is, to fill matrix[i][j], then matrix[i+1][j] and matrix[i][j+1] have to be calculated first)

public class Solution {
    public int uniquePaths(int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(m <= 0 || n <= 0) return 0;
        int[][] matrix = new int[m][n];//we can actually do this using O(n+m) space, do not need a matrix
        for(int i = 0; i < m ; i++){
            matrix[i][n-1] = 1;//the last column is one
        }
        for(int j = 0; j < n; j++){
            matrix[m-1][j] = 1;//the last row is one
        }
        //fill the matrix from row n-2 to row 0, from right to left
        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j >=0; j--){
                matrix[i][j] = matrix[i+1][j]+matrix[i][j+1];
            }
        }
        return matrix[0][0];
        
    }
}
