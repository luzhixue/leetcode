public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int totalProfit = 0;
        for(int i = 1; i < prices.length; i++)
            totalProfit += Math.max(0,prices[i]-prices[i-1]);
        return totalProfit;
        
    }
}
