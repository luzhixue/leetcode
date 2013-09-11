public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices == null || prices.length <= 1) return 0;
        int maxPrice = prices[prices.length-1], maxProfit = 0;
        for(int i = prices.length-2; i >= 0; i--){
            maxPrice = (prices[i] > maxPrice)?prices[i]:maxPrice;//maxPrice from i to end
            maxProfit = (maxPrice - prices[i] > maxProfit)? maxPrice-prices[i]:maxProfit;//profit if buy at day i
        }
        return maxProfit;
    }
}
