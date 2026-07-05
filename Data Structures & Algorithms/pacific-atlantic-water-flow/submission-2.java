class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int c = 0; c < COLS; c++){
            dfs(0, c, heights, heights[0][c], pac);
            dfs(ROWS - 1, c, heights, heights[ROWS - 1][c], atl);
        }

        for(int r = 0; r < ROWS; r++){
            dfs(r, 0, heights, heights[r][0], pac);
            dfs(r, COLS - 1, heights, heights[r][COLS - 1], atl);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pac[r][c] && atl[r][c])
                    res.add(Arrays.asList(r, c));
            }
        }

        return res;
    }

    public void dfs(int r, int c, int[][] heights, int previousHeight, boolean[][] ocean){
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || ocean[r][c] || heights[r][c] < previousHeight){
            return;
        }


        ocean[r][c] = true;

        dfs(r+1, c, heights, heights[r][c], ocean);
        dfs(r-1, c, heights, heights[r][c], ocean);
        dfs(r, c+1, heights, heights[r][c], ocean);
        dfs(r, c-1, heights, heights[r][c], ocean);
    }
}
