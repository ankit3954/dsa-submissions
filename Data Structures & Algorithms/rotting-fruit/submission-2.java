class Solution {

    public void updateCell(int[][] grid, int r, int c, Queue<int[]> q){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || grid[r][c] == 2){
            return;
        } 

        grid[r][c] = 2;
        q.offer(new int[]{r, c});
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        q.offer(new int[]{-1,-1});
        int count = 0;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            if((r == -1 && c == -1)){
                if(q.size() == 0){
                    break;
                }
                q.offer(new int[]{-1,-1});
                count++;
                continue;
            }

           

            updateCell(grid, r+1, c, q);
            updateCell(grid, r-1, c, q);
            updateCell(grid, r, c+1, q);
            updateCell(grid, r, c-1, q);

        }


        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return count;
    }
}
