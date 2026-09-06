class Solution {

    public boolean canPartHelper(int[] nums, int sum, int index){
        if(sum == 0){
            return true;
        }

        if(sum < 0){
            return false;
        }

        for(int j = index+1; j < nums.length; j++){
            boolean smallAns = canPartHelper(nums, sum - nums[j], j);
            if(smallAns){
                return true;
            }
        }

        return false;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum % 2 == 1){
            return false;
        }

        for(int i = 0; i < nums.length; i++){
            boolean ans = canPartHelper(nums, sum/2, i);
            if(ans){
                return true;
            }
        }

        return false;
    }
}
