class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){
            int firstStone = pq.poll();
            int secondStone = pq.poll();

            if(firstStone > secondStone){
                pq.add(firstStone - secondStone);
            }else{
                pq.add(secondStone - firstStone);
            }
        }

        return pq.poll();
    }
}
