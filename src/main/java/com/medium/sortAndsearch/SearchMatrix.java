package com.medium.sortAndsearch;

/**
 * @author gzd
 * @create 2018-08-13 21:09
 * @desc 搜索二维矩阵 II
 * 高效的算法
 * 个人思路：先遍历出一维数组，然后二分法查找
 **/
public class SearchMatrix {
    public static void main(String[] args){

        int[][] nums = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        long start = System.currentTimeMillis();
        boolean n = SearchMatrix.searchMatrix(nums,24);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(n);
    }


    public static boolean searchMatrix (int[][] matrix, int target) {

        if (matrix == null ){
            return false;
        }
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < aMatrix.length; j++) {
                int start = 0;
                int end = aMatrix.length - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (target == aMatrix[mid]) {
                        return true;
                    }
                    if (target > aMatrix[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

            }

        }
        return false;
    }

}
