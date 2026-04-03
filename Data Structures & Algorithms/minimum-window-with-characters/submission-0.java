class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0) return "";

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            if(countT.containsKey(t.charAt(i))){
                countT.put(t.charAt(i), countT.get(t.charAt(i)) + 1);
            }else{
                countT.put(t.charAt(i), 1);
            }
           
        }

        int resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        int have = 0, need = countT.size();
        int l = 0, r = 0;

        while(r < s.length()){
            // window.put(s.charAt(r), window.get(s.charAt(r)) + 1);
            if(window.containsKey(s.charAt(r))){
                window.put(s.charAt(r), window.get(s.charAt(r)) + 1);
            }else{
                window.put(s.charAt(r), 1);
            }
           
            if(countT.containsKey(s.charAt(r)) && countT.get(s.charAt(r)).equals(window.get(s.charAt(r)))){
                have++;
            }

            while(have == need){
                if((r-l+1) < resLen){
                    res[0] = l;
                    res[1] = r;
                    resLen = (r-l+1); 
                }

                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                if(countT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < countT.get(s.charAt(l))){
                    have--;
                }

                l++;
            }
            r++;
        }

        if(resLen == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(res[0], res[1]+1);
    }
}
