package com.sum2020.array;

import jdk.nashorn.internal.ir.ForNode;

/**
 * @author guozhongdong
 * @date 2020/3/28 21:12
 *
 * 62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 * 思路：参考题解，动态规划，画出7*3的网格,找出题目的方程
 * 则发现存在公式 dp[m][n] = dp[m-1][n]+dp[m][n-1];
 *
 */
public class UniquePaths_62 {


    public static void main(String[] args) {
        System.out.println(new UniquePaths_62().uniquePaths2(7, 3));
    }

    public int uniquePaths(int m,int n){
        // 设置一个起始值
        int[][] dp = new int[m][n];
        // 填充最上层
        for (int i = 0; i < m; i++) {
            dp[i][0] =1;
        }
        //填充最左列
        for (int i = 0; i < n; i++) {
            dp[0][i] =1;
        }
        // 填充其他边界值
        for (int a = 1; a < m; a++) {
            for (int b = 1; b < n; b++) {
                dp[a][b] = dp[a-1][b] + dp[a][b-1];

            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 初始化一维数组，设置第一个值为1，则循环给第一层赋值，则结果都为1
     * 即dp[i] = dp[i] + dp[i-1]
     * 1 1 1  1  1  1  1
     * 1 2 3  4  5  6  7
     * 1 3 6 10 15 21 28
     * */
    public int uniquePaths2(int m,int n){
        // 设置一个起始值
        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if (j > 0){
                dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        return dp[m-1];
    }
}
