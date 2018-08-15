package com.medium.array;

/**
 * @author gzd
 * @create 2018-08-15 21:26
 * @desc : 扫描矩阵，标记处0 所处的 行和列
 * 对矩阵不是很理解，勉强搜代码提交
 **/
public class SetZeroes {

    public static void main(String[] args){
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        new SetZeroes().setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {
        // 标记第一行
        boolean rowFlag = false;
        // 标记第一列
        boolean colFlag = false;

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    rowFlag = true;
                }
                if ( j == 0 ){
                    colFlag = true;
                }
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowFlag) {
            for (int i = 0; i < matrix[0].length ; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
