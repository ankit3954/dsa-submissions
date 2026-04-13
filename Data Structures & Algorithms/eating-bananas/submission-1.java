class Solution {

    public int getHours(int[] piles, int k){
        // System.out.println(k);
        int hours = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] <= k){
                hours += 1;
            }else{
                hours += piles[i]/k;
                if(piles[i] % k != 0){
                    hours += 1;
                }
            }
        }
        // System.out.println(hours);
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int left = 1;
        int right = piles[piles.length - 1];
        int res = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left)/2;
            int neededHours = getHours(piles, mid);
            if(neededHours > h){
                left = mid + 1;
            }else{
                res = Math.min(res, mid);
                right = mid - 1;
            }
        }
        return res;
    }
}
