class Solution {
    public void updateCell(int[][] grid, int r, int c, int nextDist, Queue<int[]> q){
        int ROWS = grid.length, COLS = grid[0].length;

        if(r >= 0 && r < ROWS && c >= 0 && c < COLS && grid[r][c] == Integer.MAX_VALUE){
            grid[r][c] = nextDist;
            q.offer(new int[]{r, c});
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            int nextDist = grid[r][c] + 1;

            updateCell(grid, r+1, c, nextDist, q);
            updateCell(grid, r-1, c, nextDist, q);
            updateCell(grid, r, c+1, nextDist, q);
            updateCell(grid, r, c-1, nextDist, q);
            
        }
    }
}

