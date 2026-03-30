class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] suffixArr = new int[nums.length];
        int[] prefixArr = new int[nums.length];
        int[] finalArr = new int[nums.length];
        int product = 1;

        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                suffixArr[i] = 1;
                continue;
            }

            product = product * nums[i-1];
            suffixArr[i] = product;
        }

        product = 1;
        for(int j = nums.length-1; j >= 0; j--){
            if(j == nums.length-1){
                prefixArr[j] = 1;
                continue;
            }

            product = product * nums[j+1];
            prefixArr[j] = product;
        }

        for(int k = 0; k < suffixArr.length; k++){
            finalArr[k] = suffixArr[k] * prefixArr[k];
        }

        return finalArr;

    }
}  
