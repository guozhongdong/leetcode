package com.medium.math;

/**
 * @author gzd
 * @create 2018-07-09 20:44
 * @desc 求阶乘尾数 0 的个数，
 *  =======================
 *  测试用例没提交成功，
 *  一个是尾数0 的个数，一个数结果集中所有0的个数，
 *  ====================================
 *  思路错误，开始求的直接乘的和 发现long类型存不下
 *  网上资料，阶乘后面的0 ，可以用10^K = 2^k*5^k,求得5的个数
 *
 **/
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        int sum = 0;
        while (n > 0){
            sum += n/5;
            n /= 5;
        }
        return sum;
    }

    public static void main(String[] args){
        int num = new TrailingZeroes().trailingZeroes(13);
        System.out.println(num);
    }
}
