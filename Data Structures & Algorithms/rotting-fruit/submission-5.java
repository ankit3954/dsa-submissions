class Solution {

    public void updateCell(int[][] grid, int r, int c, Queue<int[]> q, int fresh){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || grid[r][c] == 2){
            return;
        } 

        grid[r][c] = 2;
        fresh--;
        q.offer(new int[]{r, c});
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        q.offer(new int[]{-1,-1});
        int time = 0;
        while(fresh > 0 && !q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            if((r == -1 && c == -1)){
                if(q.size() == 0){
                    break;
                }
                q.offer(new int[]{-1,-1});
                time++;
                continue;
            }

           

            updateCell(grid, r+1, c, q, fresh);
            updateCell(grid, r-1, c, q, fresh);
            updateCell(grid, r, c+1, q, fresh);
            updateCell(grid, r, c-1, q, fresh);

        }


        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }
}
