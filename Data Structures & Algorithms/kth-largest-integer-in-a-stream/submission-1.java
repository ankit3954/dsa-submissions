class KthLargest {
    int k;
    PriorityQueue<Integer> pq; 
    public KthLargest(int k, int[] nums) {
       this.k = k;
        pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            add(nums[i]);
        } 
    }
    
    public int add(int val) {
        pq.add(val);

        if(pq.size() > k){
            pq.poll();
        }

        return pq.peek();

    }
}
