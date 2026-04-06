class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 2){
            return 0;
        }
        int res = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
           
            if(tokens[i].equals("+")){
                int topItem = st.pop();
                int secondTopItem = st.pop();
                res = secondTopItem + topItem;
                st.push(res);
            }else if(tokens[i].equals("*")){
                int topItem = st.pop();
                int secondTopItem = st.pop();
                res = secondTopItem * topItem;
                st.push(res);
            }else if(tokens[i].equals("/")){
                int topItem = st.pop();
                int secondTopItem = st.pop();
                res = (int)Math.floor(secondTopItem / topItem);
                st.push(res);
            }else if(tokens[i].equals("-")){
                int topItem = st.pop();
                int secondTopItem = st.pop();
                res = secondTopItem - topItem;
                st.push(res);
            }else{
                int curr = Integer.parseInt(tokens[i]);
                res = curr;
                st.push(curr);
            }
        }

        return res;
    }
}
