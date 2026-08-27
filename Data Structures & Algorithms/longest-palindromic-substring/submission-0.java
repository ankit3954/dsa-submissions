class Solution {
    public String longestPalindrome(String s) {
        int resLen = Integer.MIN_VALUE;
        String res = "";

        for(int i = 0; i < s.length(); i++){
            //odd length substring palindrome
            int l = i, r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if((r-l+1) > resLen){
                    resLen = r-l+1;
                    res = s.substring(l, r+1);
                }
                l--;
                r++;
            }

            //even length substring palindrome
            l = i;
            r = i+1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if((r-l+1) > resLen){
                    resLen = r-l+1;
                    res = s.substring(l, r+1);
                }

                l--;
                r++;
            }
        }

        return res;
    }
}
