class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;

        if(n % 2 == 1 || n == 0) return false;

        boolean res = isPowerOfTwo(n/2);
        return res;
    }
}