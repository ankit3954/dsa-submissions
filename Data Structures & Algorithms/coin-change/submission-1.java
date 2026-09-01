class Solution {
    int minSteps = Integer.MAX_VALUE;
    public void coinChangeHelper(int[] coins, int amount, int steps, int index){
        if(amount < 0){
            return;
        }

        if(amount == 0){
            minSteps = Math.min(minSteps, steps);
            return;
        }

        for(int i = index; i < coins.length; i++){
            coinChangeHelper(coins, amount - coins[index], steps+1, i);
        }


    }
    public int coinChange(int[] coins, int amount) {
        for(int i = 0; i < coins.length; i++){
            coinChangeHelper(coins, amount, 0, i);
        }
        return minSteps == Integer.MAX_VALUE ? -1 : minSteps;
    }
}
