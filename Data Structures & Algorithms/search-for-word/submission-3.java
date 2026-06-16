class Solution {

    Set<Pair<Integer, Integer>> path = new HashSet<>();
    int ROWS;
    int COLUMNS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLUMNS = board[0].length;

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLUMNS; c++){
                if(dfs(r, c, board, word, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int r, int c, char[][] board, String word, int i){
        if(i == word.length()){
            return true;
        }

        if(
            r >= ROWS || 
            c >= COLUMNS || 
            r < 0 || 
            c < 0 || 
            board[r][c] != word.charAt(i) || 
            path.contains(new Pair<>(r,c))
        ){
            return false;
        }


        path.add(new Pair<>(r,c));
        boolean res = (
            dfs(r+1, c, board, word, i+1) ||
            dfs(r-1, c, board, word, i+1) ||
            dfs(r, c+1, board, word, i+1) ||
            dfs(r, c-1, board, word, i+1) 
        );
        path.remove(new Pair<>(r,c));
        return res;
    }
}
