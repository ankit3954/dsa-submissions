class Solution {
    public void add(PriorityQueue<int[]> pq, int k, int[] points){
        pq.add(points);
        if(pq.size() > k){
            pq.poll();
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare((b[0]*b[0] + b[1]*b[1]), (a[0]*a[0] + a[1]*a[1]))
        );
        for(int i = 0; i < points.length; i++){
            add(pq, k, points[i]);
        }

        int[][] res = new int[k][2];
        for(int j = 0; j < res.length; j++){
            int[] currentDist = pq.poll(); 
            res[j][0] = currentDist[0];
            res[j][1] = currentDist[1];
        }

        return res;
    }
}
