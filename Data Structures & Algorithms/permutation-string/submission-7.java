class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;

        int matches = 0;
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1Arr[s1.charAt(i) - 'a'] += 1;
            s2Arr[s2.charAt(i) - 'a'] += 1;
        }

        for(int j = 0; j < 26; j++){
            if(s1Arr[j] == s2Arr[j]){
                matches++;
            }
        }

        for (int r = s1.length(), l = 0; r < s2.length(); r++) {
    if (matches == 26) return true;

    int rIdx = s2.charAt(r) - 'a';
    int lIdx = s2.charAt(l) - 'a';

    
    s2Arr[rIdx]++;
    if (s1Arr[rIdx] == s2Arr[rIdx]) {
        matches++; 
    } else if (s1Arr[rIdx] == s2Arr[rIdx] - 1) {
        matches--; 
    }

    // Update Left
    s2Arr[lIdx]--;
    if (s1Arr[lIdx] == s2Arr[lIdx]) {
        matches++; 
    } else if (s1Arr[lIdx] == s2Arr[lIdx] + 1) {
        matches--; 
    }

    l++;
}


        return matches == 26;
    }
}
