class Solution {
    public void solve(char[][] board) {
        boolean[][] check = new boolean[board.length][board[0].length];

        for(int c = 0; c < board[0].length; c++){
            dfs(0, c, board, check);
            dfs(board.length - 1, c, board, check);
        }

        for(int r = 0; r < board.length; r++){
            dfs(r, 0, board, check);
            dfs(r, board[0].length - 1, board, check);
        }

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(check[r][c] == false && board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }

    }

    public void dfs(int r, int c, char[][] board, boolean[][] check){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 'X' || check[r][c] == true){
            return;
        }

        check[r][c] = true;
        dfs(r+1, c, board, check);
        dfs(r-1, c, board, check);
        dfs(r, c+1, board, check);
        dfs(r, c-1, board, check);

    }
}
