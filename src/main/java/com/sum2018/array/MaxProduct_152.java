package com.sum2018.array;

/**
 * @author gzd
 * @date create in 2019/6/10 20:53
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 动态规划策略。
 *
 * 思路：设计到负数相乘，则需要记录最大值和最小值，在每一次相乘之后，判断他们的大小，
 *
 **/
public class MaxProduct_152 {

    public int maxProduct(int[] nums) {
        if (nums == null){
            return 0;
        }
        int max = nums[0];
        int imax = 0; //保存最大成绩和
        int imin = 0; //保存最小成绩和
        int maxTemp = nums[0];
        int minTemp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            imax = Math.max(nums[i] * maxTemp,nums[i] * minTemp);
            imin = Math.min(nums[i] * maxTemp,nums[i] * minTemp);
            maxTemp = Math.max(nums[i],imax);
            minTemp = Math.min(nums[i],imin);
            max = Math.max(max,maxTemp);
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {2,3,-2,4,3,0,5};
        System.out.println(new MaxProduct_152().maxProduct(nums));
    }
}
