/**
@Descriptor 买卖股票的最佳时机 II 
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
输入: prices = [7,1,5,3,6,4]
输出: 7
@auth luoye
@Date 2021-5-12 
**/

public class BuyAndSellStocks{
public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 1; i < prices.length; i++) 
            ans += Math.max(0, prices[i] - prices[i - 1]);
        return ans;
    }
}  

