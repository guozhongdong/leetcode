package com.sum2020.array;

/**
 * @author gzd
 * @date 2020/4/5 下午10:26
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 思路：参考 不同路径1 的解法，使用动态规划，把每一步的结果算出来，
 * 在此基础上 判断当前值是否是 1 ，如果是1 的话，就把当前值设置为0 。计算运算
 * 错误：考虑了两个临界值的计算，这边开始计算错误了。
 *
 * dp[i][j] = dp[i-1][j] + dp[j][i-1];
 * dp[0][j] = 1;
 * dp[i][0] = 1;
 */
public class UniquePathsWithObstacles_63 {

    public static void main(String[] args) {
        //int[][] nums = {{0,0,0,0,0,0,0},{0,0,0,1,0,0,0},{0,0,0,0,0,0,0}};
        //int[][] nums = {{0,0,0},{0,1,0},{0,0,0}};
        //int[][] nums = {{0,1}};
        //int[][] nums = {{0,1}};
        //int[][] nums = {{1},{0}};
        //[[0,0],[1,1],[0,0]]
        int[][] nums = {{0,0},{1,1},{0,0}};
        //int[][] nums = {{0}};
        System.out.println(new UniquePathsWithObstacles_63().uniquePathsWithObstacles(nums));
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        if (obstacleGrid.length == 0){
            return 0;
        }
        // 判断两个临界值
        if (obstacleGrid[0][0] ==1 ){
            return 0;
        }
        obstacleGrid[0][0] =1 ;
        for (int j = 1; j < obstacleGrid[0].length; j++) {

            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1) ? 1 : 0;

        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;

        }

        for (int m = 1; m < obstacleGrid.length; m++) {
            for ( int n = 1; n < obstacleGrid[0].length; n++) {

                if (obstacleGrid[m][n] == 1){
                    obstacleGrid[m][n] = 0;
                }else{
                    obstacleGrid[m][n] = obstacleGrid[m-1][n] + obstacleGrid[m][n-1];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
