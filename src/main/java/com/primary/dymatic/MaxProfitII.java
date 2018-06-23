package com.primary.dymatic;

/**
 * @author gzd
 * @create 2018-06-22 13:55
 * @desc:买卖股票的最佳时机二
 * 思路：找到一个最小值，然后往后找，跟这个最小值的差 比较，保留差值的最大值
 **/
public class MaxProfitII {
    public static void main(String[] args){
        int[] nums = {7,1,5,3,6,4};
        int n = new MaxProfitII().maxProfit(nums);
        System.out.println(n);
    }
    public int maxProfit(int[] prices) {
        int temp = 0;
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length ; i++) {
                sum = Math.min(sum,prices[i]);
                temp = Math.max(temp,prices[i]-sum);
        }
        return temp;
    }
}
