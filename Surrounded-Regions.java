public class Solution {
    //stack overflow error for large problems, might need a bfs method
    int rowNum = 0, colNum = 0;
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board == null || board.length == 0) return;
        rowNum = board.length;
        colNum = board[0].length;
        for(int i = 0; i < rowNum; i++){
            dfsMark(board, i, 0);
            dfsMark(board, i, colNum-1);
        }
        for(int j = 0; j < colNum; j++){
            dfsMark(board, 0, j);
            dfsMark(board, rowNum-1, j);
        }
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(board[i][j] == '#') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    
    private void dfsMark(char[][] board, int i, int j){
        if(i < 0 || i >= rowNum || j < 0 || j >= colNum || board[i][j] != 'O')
            return;
        board[i][j] = '#';
        dfsMark(board, i-1, j);
        dfsMark(board, i+1, j);
        dfsMark(board, i, j-1);
        dfsMark(board, i, j+1);
    }
}
