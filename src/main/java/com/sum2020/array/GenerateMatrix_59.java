package com.sum2020.array;

/**
 * @author gzd
 * @date 2020/4/2 下午9:52
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *  画图，找临界值，
 *  思路：选取四个临界值，依次是left --- right,tio --- bottom ,right -- left,bottom --- top,
 *  指导累加的值等于 n*n
 */
public class GenerateMatrix_59 {

    public static void main(String[] args) {

        new GenerateMatrix_59().generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {

        int l = 0,r = n-1,top = 0,bottom = n-1;
        int num = 1;
        int max = n*n;
        int[][] arrays = new int[n][n];
        while (num <= max){
             // 从左 到右
            for (int i = l; i <= r; i++) {
                arrays[top][i] = num++;
            }
            top++;
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                arrays[i][r] = num++;
            }
            // 右侧一列满了
            r--;
            for (int i = r; i >= l; i--) {
                arrays[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                arrays[i][l] = num++;
            }
            l++;

        }

        return arrays;
    }

}
