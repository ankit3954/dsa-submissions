class MinStack {
    int[] data;
    int nextIndex;
    int capacity;

    public MinStack() {
        data = new int[4];
        nextIndex = 0;
        capacity = 4;
    }
    
    public void push(int val) {
        if(capacity == nextIndex){
            int[] newData = new int[2 * capacity];
            for(int i = 0; i < capacity; i++){
                newData[i] = data[i];
            }

            capacity *= 2;
            data = newData;
        }
        data[nextIndex] = val;
        nextIndex++;
    }
    
    public void pop() {
        // if(nextIndex == 0){
        //     return null;
        // }
        nextIndex--;
    }
    
    public int top() {
        // if(nextIndex == 0){
        //     return null;
        // }
        return data[nextIndex - 1];
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nextIndex; i++){
            min = Math.min(min, data[i]);
        }

        return min;
    }
}
