/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */
import java.util.Stack;
// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int i = 0;
        if(prices.length==0) return res;
        Stack<Integer> min= new Stack();
        min.push(prices[i]);
        for(i=1;i<prices.length-1;++i){
            if(prices[i]<prices[i-1] && prices[i]<=prices[i+1]){
                if(!min.isEmpty())min.pop();
                min.push(prices[i]);
            } else if(prices[i]>=prices[i-1] && prices[i]>prices[i+1]){
                res += (prices[i]-min.pop());
            }
        }
        if(prices.length>1&&prices[i]>=prices[i-1]&&!min.isEmpty()){
            res += (prices[i]-min.pop());
        }
        return res;
    }
}
// @lc code=end

