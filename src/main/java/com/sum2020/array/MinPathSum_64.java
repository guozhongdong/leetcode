package com.sum2020.array;

/**
 * @author guozhongdong
 * @date 2020/3/29 10:06
 *
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 思路：暴力解法，递归解法，
 * num[0][0] 判断它的右边和它下边两条路的最优解
 * 同理判断 num[0][1] 和num[1][0] 的最优解
 * cost[i][j] = num[i][j] +min(num[i-1][j],num[i][j+1])
 */
public class MinPathSum_64 {
    public static void main(String[] args) {
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        //System.out.println(new MinPathSum_64().searchMax(nums, 0, 0));
        //System.out.println(new MinPathSum_64().searchMax2(nums));
        //System.out.println(new MinPathSum_64().searchMax3(nums));
        System.out.println(new MinPathSum_64().searchMax4(nums));
    }
    /**
     *
     *  超出时间限制，AC不了
     */
    public int searchMax(int[][] nums,int i,int j){
        // 设置最后一个值为默认最大，求最小值
        if (i == nums.length || j == nums[0].length){
            return Integer.MAX_VALUE;
        }
        // 返回最里面的那个值
        if (i == nums.length-1 && j == nums[0].length -1){
            return nums[i][j];
        }
        //nums[i][j] = nums[i][j] + Math.min(searchMax(nums,i+1,j),searchMax(nums,i,j+1));


        return nums[i][j] + Math.min(searchMax(nums,i+1,j),searchMax(nums,i,j+1));
    }

    /**
     *  动态规划
     *  开出额外空间，用于一个二维数组dp 每一步走出的最小值
     *  倒着算
     */
    public int searchMax2(int[][] nums){
        int[][] dp = new int[nums.length][nums[0].length];
        for (int i = dp.length -1 ; i >= 0 ; i--) {
            for (int j = dp[0].length-1; j >=0 ; j--) {
                if (i == nums.length-1 && j != nums[0].length -1){
                    dp[i][j] = nums[i][j]+dp[i][j+1];
                }else if (i != nums.length-1 && j == nums[0].length -1){
                    dp[i][j] = nums[i][j]+dp[i+1][j];
                }else if(i != nums.length-1 && j != nums[0].length -1 ) {
                    dp[i][j] = nums[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
                }else{
                    dp[i][j] = nums[i][j];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 一维数组存 值
     * */
    public int searchMax3(int[][] nums){
        int[] dp = new int[nums.length];
        for (int i = nums.length -1 ; i >= 0 ; i--) {
            for (int j = nums[0].length-1; j >=0 ; j--) {
                if (i == nums.length-1 && j != nums[0].length -1){
                    dp[j] = nums[i][j]+dp[j+1];
                }else if (i != nums.length-1 && j == nums[0].length -1){
                    dp[j] = nums[i][j]+dp[j];
                }else if(i != nums.length-1 && j != nums[0].length -1 ) {
                    dp[j] = nums[i][j]+Math.min(dp[j],dp[j+1]);
                }else{
                    dp[j] = nums[i][j];
                }
            }
        }
        return dp[0];
    }
    /**
     * 在原数组上存执，不需要额外空间
     * */
    public int searchMax4(int[][] nums){

        for (int i = nums.length -1 ; i >= 0 ; i--) {
            for (int j = nums[0].length-1; j >=0 ; j--) {
                if (i == nums.length-1 && j != nums[0].length -1){
                    nums[i][j] = nums[i][j]+nums[i][j+1];
                }else if (i != nums.length-1 && j == nums[0].length -1){
                    nums[i][j] = nums[i][j]+nums[i+1][j];
                }else if(i != nums.length-1 && j != nums[0].length -1 ) {
                    nums[i][j] = nums[i][j]+Math.min(nums[i][j+1],nums[i+1][j]);
                }else{
                    nums[i][j] = nums[i][j];
                }
            }
        }
        return nums[0][0];
    }
}
