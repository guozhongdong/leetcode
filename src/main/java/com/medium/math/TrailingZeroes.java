package com.medium.math;

/**
 * @author gzd
 * @create 2018-07-09 20:44
 * @desc 求阶乘尾数 0 的个数，
 *  =======================
 *  测试用例没提交成功，
 *  一个是尾数0 的个数，一个数结果集中所有0的个数，
 **/
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        if (n == 0 ){
            return 0;
        }
        int sum = 1;
        while (n > 1){
            sum = sum * n;
            n--;
        }
        /*int count = 0;
        while (sum%10 == 0){
            count++;
            sum = sum/10;
        }*/
        int count = 0;
        int num = new TrailingZeroes().trailingZeroes(7);
        System.out.println(count);
        //System.out.println(sum % 10);
        System.out.println(sum);
        return count;
    }

    public static void main(String[] args){
        int num = new TrailingZeroes().trailingZeroes(10);
        System.out.println(num);
    }
}
