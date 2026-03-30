

class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> anagramMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            if(anagramMap.containsKey(s.charAt(i))){
                anagramMap.put(s.charAt(i), anagramMap.get(s.charAt(i)) + 1);
            }else{
                 anagramMap.put(s.charAt(i), 1);
            }
        }

         for (int j = 0; j < t.length(); j++){
            if(anagramMap.containsKey(t.charAt(j))){
                anagramMap.put(t.charAt(j), anagramMap.get(t.charAt(j)) - 1);
            }else{
                 return false;
            }
        }

        for (Integer value : anagramMap.values()) {
            if(value != 0){
                return false;
            }
        }

        return true;
    }
}
