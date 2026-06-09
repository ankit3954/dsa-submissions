class MedianFinder {
    PriorityQueue<Integer> firstHalf;  // Max-heap
    PriorityQueue<Integer> secondHalf; // Min-heap

    public MedianFinder() {
        firstHalf = new PriorityQueue<>(Collections.reverseOrder());
        secondHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Greedily filter the number through the max-heap
        firstHalf.add(num);
        secondHalf.add(firstHalf.poll());
        
        // Step 2: Maintain size balance (firstHalf can have at most 1 more element)
        if (secondHalf.size() > firstHalf.size()) {
            firstHalf.add(secondHalf.poll());
        }
    }
    
    public double findMedian() {
        if (firstHalf.size() > secondHalf.size()) {
            return firstHalf.peek();
        }
        return (double) (firstHalf.peek() + secondHalf.peek()) / 2.0;
    }
}
