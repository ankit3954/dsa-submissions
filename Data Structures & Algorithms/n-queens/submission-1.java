class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                board[r][c] = '.';
            }
        }

        backtrack(0, board, res);
        return res;
    }

    public void backtrack(int r, char[][] board, List<List<String>> res){
        if(r == board.length){
            List<String> copy = new ArrayList<>();
            for(char[] row: board){
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int c = 0; c < board.length; c++){
            if(isSafe(r, c, board)){
                board[r][c] = 'Q';
                backtrack(r + 1, board, res);
                board[r][c] = '.';
            }
        }
    }

    public boolean isSafe(int r, int c, char[][] board){
        for(int i = r-1; i >= 0; i--){
            if(board[i][c] == 'Q'){
                return false;
            }
        }

        for(int j = r-1, k = c+1; j >= 0 && k < board.length; j--, k++){
            if(board[j][k] == 'Q'){
                return false;
            }
        }

        for(int l = r-1, m = c-1; l >= 0 && m >= 0; l--, m--){
            if(board[l][m] == 'Q'){
                return false;
            }
        }

        return true;
    }
}
