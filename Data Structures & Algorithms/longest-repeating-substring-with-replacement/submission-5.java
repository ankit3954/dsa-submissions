class Solution {

    public int mostFrequentChar(HashMap<Character, Integer> hm){
        int maxVal = 0;

        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
            }
        }

        return maxVal;
    }
    public int characterReplacement(String s, int k) {
        int res = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            // 1. Add current character to map
            char rightChar = s.charAt(r);
            hm.put(rightChar, hm.getOrDefault(rightChar, 0) + 1);

            // 2. Check if window is invalid: (Window Size - Max Frequency > k)
            // We use a while loop to shrink until it's valid again
            while ((r - l + 1) - mostFrequentChar(hm) > k) {
                char leftChar = s.charAt(l);
                hm.put(leftChar, hm.get(leftChar) - 1); // DECREMENT frequency
                l++; // MOVE left pointer
            }

            // 3. Update the max result
            res = Math.max(res, r - l + 1);
        }

        return res;
    
}}
