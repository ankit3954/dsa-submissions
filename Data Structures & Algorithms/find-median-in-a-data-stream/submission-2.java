class MedianFinder {
    PriorityQueue<Integer> firstHalf;
    PriorityQueue<Integer> secondHalf;

    public MedianFinder() {
        firstHalf = new PriorityQueue<>(Collections.reverseOrder());
        secondHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(secondHalf.size() == 0 || num > secondHalf.peek()){
            secondHalf.add(num);
        }else{
            firstHalf.add(num);
        }
      

       if(secondHalf.size() - firstHalf.size() > 1){
            int elem = secondHalf.poll();
            firstHalf.add(elem);
       }else if(firstHalf.size() - secondHalf.size() > 1){
            int elem = firstHalf.poll();
            secondHalf.add(elem);
       }
    }
    
    public double findMedian() {
        double res = 0;
        if(secondHalf.size() == firstHalf.size()){
            res = (double)(secondHalf.peek() + firstHalf.peek())/2;
        }else if(secondHalf.size() > firstHalf.size()){
            res = (double)(secondHalf.peek());
        }else{
            res = (double)(firstHalf.peek());
        }

        return res;
    }
}
