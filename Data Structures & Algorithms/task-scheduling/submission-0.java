class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] chr = new int[26];
        for(char task : tasks){
            chr[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < chr.length; i++){
            if(chr[i] > 0){
                pq.add(chr[i]);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(!pq.isEmpty()){
                int cnt = pq.poll() - 1;
                if(cnt > 0){
                    q.add(new int[]{cnt, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            }
        }

        return time;
    }
}
