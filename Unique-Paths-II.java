public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        if(obstacleGrid[0].length == 0) return 0;
        int rowNum = obstacleGrid.length, colNum = obstacleGrid[0].length;
        int[][] paths = new int[rowNum][colNum];
        for(int i = rowNum-1; i >= 0; i--){//the last column, if there has been a 0 somewhere down, then there is no path
            if(i == rowNum-1) paths[i][colNum-1] = (obstacleGrid[i][colNum-1] == 1)?0:1;
            else paths[i][colNum-1] = (paths[i+1][colNum-1] == 0 || obstacleGrid[i][colNum-1] == 1)?0:paths[i+1][colNum-1];
        }
        for(int j = colNum-2; j >= 0; j--){//the last row, if there has been a 0 somewhere after me, then there is no path
            paths[rowNum-1][j] = (paths[rowNum-1][j+1] == 0 || obstacleGrid[rowNum-1][j] == 1)?0:paths[rowNum-1][j+1];
        }
        for(int i = rowNum-2; i >= 0; i--){
            for(int j = colNum-2; j >= 0; j--){
                if(obstacleGrid[i][j] == 1) paths[i][j] = 0;//if there is a block, there is no path
                else paths[i][j] = paths[i+1][j] + paths[i][j+1];
            }
        }
        return paths[0][0];
    }
}
