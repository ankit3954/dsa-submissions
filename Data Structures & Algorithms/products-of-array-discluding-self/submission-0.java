class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int product = 1;
        int zeroCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
                continue;
            }
            product = product * nums[i];
        }

        if(zeroCount > 1){
            return output;
        }

        for(int j = 0; j < output.length; j++){
            if(zeroCount == 1){
                if(nums[j] == 0){
                    output[j] = product;
                    continue;
                }
            }else{
                 output[j] = product / nums[j];
            }
        }

        return output;
    }
}  
