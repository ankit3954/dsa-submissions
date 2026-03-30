class Solution {
    public int maxProfit(int[] prices) {
        int[] rightMax = new int[prices.length];
        int maxElem = 0;
        int maxProfit = 0;
        int i = prices.length-1;
        while(i > 0){
            i--;
            maxElem = Math.max(prices[i+1], rightMax[i+1]);
            rightMax[i] = maxElem;
            maxProfit = Math.max(maxProfit, rightMax[i] - prices[i]);
        }

        return maxProfit;
    }
}
