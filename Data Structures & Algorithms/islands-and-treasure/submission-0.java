class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    dfs(grid, i, j, 0);
                }
            }
        }
    }

    public void dfs(int[][] grid, int i, int j, int val){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] < val){
            return;
        }

        grid[i][j] = val;
        dfs(grid, i+1, j, 1 + grid[i][j]);
        dfs(grid, i-1, j, 1 + grid[i][j]);
        dfs(grid, i, j+1, 1 + grid[i][j]);
        dfs(grid, i, j-1, 1 + grid[i][j]);
        
    }
}
