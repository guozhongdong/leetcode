package com.sum2020.array;

/**
 * @author gzd
 * @date 2020/4/6 下午8:44
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * 思路：先低效的算出结果，之后再进行高效的优化
 * 低效之法：按每一行最后边的临界值判断，之后遍历这一行
 *
 *
 */
public class SearchMatrix_74 {

    public static void main(String[] args) {
        int[][] nums = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        //int[][] nums = {{1}};
        System.out.println(new SearchMatrix_74().searchMatrix(nums, 3));
        System.out.println(new SearchMatrix_74().searchMatrix2(nums, 3));
    }
    // 普通解法
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (target <= matrix[i][n-1]){
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == target){
                        return true;
                    }
                }
            }

        }

        return false;
    }

    /**
     * 将二维数组拆分为 虚数组，使用二分法查找
     * */
    public boolean searchMatrix2(int[][] matrix, int target) {

        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }
}
