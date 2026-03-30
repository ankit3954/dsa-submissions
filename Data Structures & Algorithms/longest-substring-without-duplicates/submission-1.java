class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            return 0;
        }

        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){

            while(charMap.containsKey(s.charAt(r))){
                charMap.remove(s.charAt(l));
                l++;
            }

            charMap.put(s.charAt(r), 1);
            maxLength = Math.max(maxLength, r - l + 1);
 
        }

        return maxLength;
    }
}
