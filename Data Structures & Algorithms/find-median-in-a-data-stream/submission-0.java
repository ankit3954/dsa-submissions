class MedianFinder {
    PriorityQueue<Integer> nums;

    public MedianFinder() {
        nums = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
       nums.add(num);
    }
    
    public double findMedian() {
        int[] arr = new int[nums.size()];
        double res = 0;
        for(int i = 0; i < arr.length; i++){
            arr[i] = nums.poll();
        }

        if(arr.length%2 == 1){
            res =(double)arr[arr.length / 2];
        }else{
            res = (double)(arr[arr.length / 2] + arr[(arr.length-1) / 2])/2;
        }

        for(int j = 0; j < arr.length; j++){
            nums.add(arr[j]);
        }

        return res;
    }
}
