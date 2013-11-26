//For example,
//There exist two distinct solutions to the 4-queens puzzle:
/*[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]*/


public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String[]> ret = new ArrayList<String[]>();
        if(n <= 0) return ret;
        int[] col = new int[n];
        queenHelper(col, 0, ret);
        return ret;
    }
    
    private void queenHelper(int[] col, int curIdx, ArrayList<String[]> ret){
        if(curIdx >= col.length){//finished
            String[] result = getResult(col);
            ret.add(result);
            return;
        }
        for(int i = 0; i < col.length; i++){//for row curIdx, try each column
            if(legalPosition(col, curIdx, i)){
                col[curIdx] = i;
                queenHelper(col, curIdx+1, ret);
                col[curIdx] = -1;//not necessary, should just note this
            }
        }
    }
    
    private String[] getResult(int[] col){
        String[] result = new String[col.length];
        for(int i = 0; i < col.length; i++){//at row i
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col.length; j++)//at column j
                sb.append(((col[i]==j)?"Q":"."));
            result[i] = sb.toString();
        }
        return result;
    }
    
    private boolean legalPosition(int[] col, int curIdx, int curColumn){
        if(curIdx < 0 || curIdx >= col.length) return false;
        for(int i = 0; i < curIdx; i++){
            if(col[i] == curColumn || Math.abs(curIdx-i) == Math.abs(curColumn-col[i]))
                return false;
        }
        return true;
    }
}
