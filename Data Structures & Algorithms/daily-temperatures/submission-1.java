class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i = temperatures.length - 1; i >= 0; i--){
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek() - 1]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = st.peek() - (i + 1);
            }

            st.push(i+1);
        }

        return res;
    }
}
