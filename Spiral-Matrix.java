public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length == 0 || matrix[0].length == 0) return new ArrayList<Integer>();
        return recursiveSpiral(matrix, 0, matrix.length-1, 0, matrix[0].length-1);
    }
    
    private ArrayList<Integer> recursiveSpiral(int[][] matrix, int minRowNum, int maxRowNum, int minColNum, int maxColNum){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(maxRowNum<minRowNum || maxColNum<minColNum) return list;
        if(maxRowNum-minRowNum == 0){
            for(int i = minColNum; i<=maxColNum; i++)
                list.add(matrix[minRowNum][i]);
            return list;
        }
        if(maxColNum-minColNum == 0){
            for(int i = minRowNum; i<=maxRowNum; i++)
                list.add(matrix[i][minColNum]);
            return list;
        }
        for(int i = minColNum; i <= maxColNum; i++)
            list.add(matrix[minRowNum][i]);
        for(int i = minRowNum+1; i <= maxRowNum; i++)
            list.add(matrix[i][maxColNum]);
        for(int i = maxColNum-1; i >= minColNum; i--)
            list.add(matrix[maxRowNum][i]);
        for(int i = maxRowNum-1; i >= minRowNum+1; i--)
            list.add(matrix[i][minColNum]);
        list.addAll(recursiveSpiral(matrix, minRowNum+1, maxRowNum-1, minColNum+1, maxColNum-1));
        return list;
    }
    
}


//There is a iterative solution without using recursion
//http://discuss.leetcode.com/questions/29/spiral-matrix
