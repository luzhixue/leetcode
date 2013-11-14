//perform DFS search: the branch factor of the search is 3, so the worst-complexity is 3^k for a single search  (k is the length of the word)
//then the total complexity might be:  m*n*3^k
public class Solution {
    public boolean exist(char[][] board, String word) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(word == null || word.length() == 0) return true;
        if(board == null || board.length == 0) return false;
        int height = board.length, width = board[0].length;
        boolean[][] taken = new boolean[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(recurseWordExist(board, i, j, word, 0, taken))
                    return true;
            }
        }
        return false;
    }
    
    //find curIdx character of string at location i,j
    public boolean recurseWordExist(char[][] board, int i, int j, String word, int curIdx, boolean[][] taken){
        if(curIdx == word.length()) return true;//finished
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;//out of bound
        if(taken[i][j] || board[i][j] != word.charAt(curIdx)) return false;//taken by previous or does not match
        taken[i][j] = true;
        //search around
        boolean findLeft = recurseWordExist(board, i-1, j, word, curIdx+1, taken);
        if(findLeft) return true;
        findLeft = recurseWordExist(board, i+1, j, word, curIdx+1, taken);
        if(findLeft) return true;
        findLeft = recurseWordExist(board, i, j-1, word, curIdx+1, taken);
        if(findLeft) return true;
        findLeft = recurseWordExist(board, i, j+1, word, curIdx+1, taken);
        if(findLeft) return true;
        taken[i][j] = false;
        return false;
    }
}
