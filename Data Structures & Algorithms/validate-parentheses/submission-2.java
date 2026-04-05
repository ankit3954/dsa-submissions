class Solution {
    public boolean isValid(String s) {

        if(s.length() == 0 || s.length() == 1){
            return false;
        }

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }else{
                if(st.size() == 0){
                    return false;
                }
                
                char topElem = st.peek();
                if(s.charAt(i) == ')' && topElem == '('){
                    st.pop();
                }else if(s.charAt(i) == '}' && topElem == '{'){
                    st.pop();
                }else if(s.charAt(i) == ']' && topElem == '['){
                    st.pop();
                }else{
                    return false;
                }
            }
        }

        return st.size() == 0;
    }
}
