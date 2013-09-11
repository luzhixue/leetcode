public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices == null || prices.length <= 1) return 0;
        int[] maxOneProfit = new int[prices.length];
        maxOneProfit[prices.length-1] = 0;
        int maxValue = prices[prices.length-1];
        for(int i = prices.length-2; i >= 0; i--){
            maxValue = Math.max(maxValue,prices[i]);//maxValue from i to end
            maxOneProfit[i] = Math.max(maxValue-prices[i],maxOneProfit[i+1]);//max possible profit from one transaction
        }
        int minValue = prices[0], firstProfit = 0, maxTotal = 0;
        for(int i = 0; i < prices.length-1; i++){
            minValue = Math.min(minValue, prices[i]);
            firstProfit = Math.max(firstProfit, prices[i]-minValue);
            maxTotal = Math.max(firstProfit+maxOneProfit[i],maxTotal);
        }
        return maxTotal;
    }
}

//extend to m transactions:
//http://discuss.leetcode.com/questions/287/best-time-to-buy-and-sell-stock-iii
