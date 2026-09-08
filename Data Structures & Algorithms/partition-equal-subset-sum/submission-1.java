public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // If the total sum is odd, it cannot be split into two equal integer subsets
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        // 1D array to store target tracking states
        boolean[] dp = new boolean[target + 1];
        
        // Base case: A target sum of 0 is always possible (empty subset)
        dp[0] = true;

        // Process each number
        for (int num : nums) {
            // Traverse backwards to prevent using the same element multiple times
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
