/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        if(prices.length==0) return max_profit;
        int min_price = prices[0];
        for(int i=0;i<prices.length; ++i){
            if(i==0){
                min_price = prices[i];
            } else if(prices[i] - min_price > max_profit){
                max_profit = prices[i] - min_price;
            } else if(prices[i] < min_price){
                min_price = prices[i];
            }
        }
        return max_profit;
    }
}
// @lc code=end

