package com.medium.math;

/**
 * @author gzd
 * @create 2018-07-10 22:00
 * @desc 两数相除
 *  思路：通过位运算,先算出两个数的符号位，通过位移算法计算
 *  2、可使用二分法，
 *
 *
 **/
public class Divide {

    public static void main(String[] args){
        int num = new Divide().divide(-23,3);
        System.out.println(num);
        //System.out.println(-7/2);
    }
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // 求符号位
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        // 求绝对值，防止溢出 使用lang
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;
        while (dvd >= dvs) {
            // 记录除数
            long tmp = dvs;
            // 记录商的大小
            long mul = 1;

            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }

            // 减去最接近dvd的dvs的指数倍的值（值为tmp）
            dvd -= tmp;

            // 修正结果
            result += mul;
        }

        return result * sign;

    }
}
