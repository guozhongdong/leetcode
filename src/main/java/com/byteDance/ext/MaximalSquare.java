package com.byteDance.ext;

/**
 * @author gzd
 * @create 2018-12-21 22:08
 * @desc 最大正方形
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 * 思路：题型是动态和贪心算法
 * 判断一个数的 右和下 是否都为1,不为1 ，往下找，
 * 不太懂
 *
 **/
public class MaximalSquare {

    public static void main(String[] args){
        char[][] chars = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
       int n = new MaximalSquare().maximalSquare(chars);
       System.out.println(n);
    }
    public int maximalSquare(char[][] matrix) {
        if (matrix.length ==0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0,pre = 0;
        int[] newChar = new int[m+1];
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= m; i++) {
                int t = newChar[i];
                if (matrix[i-1][j] == '1'){
                    newChar[i] = Math.min(newChar[i],Math.min(newChar[i-1],pre))+1;
                    res = Math.max(res,newChar[i]);
                }else{
                    newChar[i] = 0;
                }
                pre = t;
            }

        }

        return res*res;
    }

}
