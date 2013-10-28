public class Solution {
    boolean found = false;
    public void solveSudoku(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(board == null || board.length != 9 || board[0].length != 9) return;
        //ArrayList<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>();
        //ArrayList<HashSet<Integer>> cols = new ArrayList<HashSet<Integer>>();
        //ArrayList<HashSet<Integer>> blocks = new ArrayList<HashSet<Integer>>();
        //for(int i = 0; i < 9; i++){
        //    rows.add(new HashSet<Integer>());
        //    cols.add(new HashSet<Integer>());
        //    blocks.add(new HashSet<Integer>());
        //}
        found = false;
        boolean[][] rows = new boolean[9][9];//row[i][j] == true means row i has number j+1
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int val = Character.getNumericValue(board[i][j]);
                    int blockIdx = getBlockIdx(i,j);
                    rows[i][val-1] = cols[j][val-1] = blocks[blockIdx][val-1] = true;
                }
            }
        }
        recurseSuduku(0, board, rows, cols, blocks);
    }
    
    private void recurseSuduku(int curIdx, char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] blocks){
        if(found)
            return;
        int rowIdx = curIdx/9;
        int colIdx = curIdx%9;
        int blockIdx = getBlockIdx(rowIdx, colIdx);
        if(rowIdx > 8){//finished
            found = true;
            return;
        }
        if(board[rowIdx][colIdx] != '.'){
            recurseSuduku(curIdx+1, board, rows, cols, blocks);//go to the next step
            return;
        }
        else{
            for(char c = '1'; c <= '9'; c++){
                int val = Character.getNumericValue(c);
                if(rows[rowIdx][val-1] || cols[colIdx][val-1] || blocks[blockIdx][val-1])//contain this element
                    continue;
                else{
                    board[rowIdx][colIdx] = c;//fill with c
                    rows[rowIdx][val-1] = cols[colIdx][val-1] = blocks[blockIdx][val-1] = true;//
                    recurseSuduku(curIdx+1, board, rows, cols, blocks);//go to the next step
                    if(found) return;
                    board[rowIdx][colIdx] = '.';//unfill
                    rows[rowIdx][val-1] = cols[colIdx][val-1] = blocks[blockIdx][val-1] = false;
                }
            }
        }
    }
    
    private int getBlockIdx(int rowIdx, int colIdx){
        return rowIdx/3*3 + colIdx/3;
    }
}
