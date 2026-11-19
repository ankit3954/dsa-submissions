class Solution {
    public boolean isAnagram(String s, String t) {
        // 1. Fail fast if lengths don't match
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hm = new HashMap<>();

        // 2. Count characters in 's' in one clean line
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        // 3. Subtract counts using 't'
        for (char c : t.toCharArray()) {
            int count = hm.getOrDefault(c, 0);
            if (count == 0) {
                return false; // Character missing or appeared too many times
            }
            hm.put(c, count - 1);
        }

        return true;
    }
}
