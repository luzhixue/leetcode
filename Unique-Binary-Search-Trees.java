//Dynamic Programming, numBST[i][j] is the number of unique BSTs from (index) i to (index) j
public class Solution {
    public int numTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(n <= 0) return 0;
        int[][] numBST = new int[n][n];
        for(int i = 0; i < n; i++){
            numBST[i][i] = 1;
        }
        for(int step = 1; step < n; step++){
            for(int i = 0; i < n-step; i++){
                int j = i + step;
                int total = 0;
                for(int rootIdx = i; rootIdx <= j; rootIdx++){
                    int leftNum = (rootIdx-1<i)?1:numBST[i][rootIdx-1];
                    int rightNum = (rootIdx+1>j)?1:numBST[rootIdx+1][j];
                    total += leftNum * rightNum;
                }
                numBST[i][j] = total;
            }
        }
        return numBST[0][n-1];
    }

}
