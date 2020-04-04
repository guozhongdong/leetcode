package com.sum2020.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzd
 * @date 2020/4/4 上午10:10
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 思路：设置边界值，然后遍历，按顺序遍历
 */
public class SpiralOrder_54 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12}};
        //int[][] nums = {{1, 2, 3},{4,5, 6},{7, 8,9}};
        //int[][] nums = {{1, 2},{4,5}};
        System.out.println(new SpiralOrder_54().spiralOrder(nums));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0){
            return list;
        }

        int l=0,r = matrix[0].length-1,top = 0,b = matrix.length-1;
        while(l <= r && top <= b){
            for (int i = l; i <= r; i++) {
                list.add(matrix[l][i]);
            }

            for (int i = top+1; i <= b; i++) {
                list.add(matrix[i][r]);
            }

            if (l < r && top < b){
                for (int i = r-1; i >= l; i--) {
                    list.add(matrix[b][i]);
                }

                for (int i = b-1; i >= top+1  ; i--) {
                    list.add(matrix[i][l]);
                }

            }
            top++;
            r--;
            b--;
            l++;


        }

        return list;
    }
}
