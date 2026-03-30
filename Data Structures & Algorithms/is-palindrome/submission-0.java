class Solution {
    public boolean isPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i < j; ){
            char a = s.charAt(i);
            char b = s.charAt(j);

            if(!((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || (a >= '0' && a <= '9'))){
                i++;
                continue;
            } 
            if(!((b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z') || (b >= '0' && b <= '9'))){
                j--;
                continue;
            }


            if(!(Character.toLowerCase(a) == Character.toLowerCase(b))){
                return false;
            }

            i++;
            j--;
        }

        return true;

    }
}
