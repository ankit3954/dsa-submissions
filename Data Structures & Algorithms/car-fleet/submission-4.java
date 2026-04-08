class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 1 && speed.length == 1){
            return 1;
        }

        int n = position.length;
        int[][] cars = new int[n][2];

        // Pair them up
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; // Position
            cars[i][1] = speed[i];    // Speed
        }

        // Sort descending by position (index 0)
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> st = new Stack<>();

        for(int i = 0; i < cars.length; i++){
            double remTime =(double) (target - cars[i][0])/cars[i][1];
            System.out.println(remTime);
             if(st.isEmpty()){
                st.push(remTime);
            }
            else if(!st.isEmpty() && remTime > st.peek()){
                st.push(remTime);
            }
        }
        
        return st.size();
    }
}
