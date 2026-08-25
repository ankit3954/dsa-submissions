class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] ans = new int[cost.length];
        ans[cost.length - 1] = cost[cost.length - 1];
        ans[cost.length - 2] = cost[cost.length - 2];

        for(int i = cost.length - 3; i >= 0; i--){
            ans[i] = cost[i] + Math.min(ans[i+1], ans[i+2]);
        }

        return Math.min(ans[0], ans[1]);

    }
}
