package com.primary.array;

/**
 * @author gzd
 * @create 2018-05-29 13:44
 * @desc 买卖股票的最佳时机 II
 * 思路：只要第二天的股票的价格 比第一天的价格高，就进行一次买卖
 * 算法：贪心算法------https://baike.baidu.com/item/%E8%B4%AA%E5%BF%83%E7%AE%97%E6%B3%95/5411800?fr=aladdin
 **/
public class MaxProfit {

    public static void main(String[] args){
        int[] prices = {1,2,3,4,5};
        maxProfit(prices);
    }
    public static  int maxProfit(int[] prices) {
        if (prices ==null  && prices.length == 0)
            return 0;

        int price = 0;  //获取单个操作的利润
        int result = 0; // 获取整个的利润
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<prices[i-1])
                continue;
            price = prices[i] - prices[i-1];
            result = result+price;

        }

        return result;
    }
}
