class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[nums.length] = 0;
        dp[nums.length - 1] = 1;

        int maxLenPos = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[maxLenPos]){
                dp[i] = 1 + dp[maxLenPos];
                maxLenPos = i;
            }else if(nums[i] == nums[maxLenPos]){
                dp[i] = dp[maxLenPos];
                maxLenPos = i;
            }else{
                for(int j = i+1; j < nums.length; j++){
                    if(nums[j] > nums[i]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                if(dp[i] >= dp[maxLenPos]){
                    maxLenPos = i;
                }
                if(dp[i] == 0){
                    dp[i] = 1;
                }
            }
        }


        return dp[maxLenPos];
    }
}
