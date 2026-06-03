class KthLargest {

    int k;
    PriorityQueue<Integer> pq; 
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
    }
    
    public int add(int val) {
        List<Integer> l = new ArrayList<>();
        pq.add(val);
        for(int i = 1; i < k; i++){
            l.add(pq.poll());
        }

        int res = pq.peek();
        for(int i = 0; i < l.size(); i++){
            pq.add(l.get(i));
        }

        return res;
    }
}
