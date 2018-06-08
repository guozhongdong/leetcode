package com.primary.math;

/**
 * @author gzd
 * @create 2018-06-07 14:01
 * @desc 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 **/
public class IsPowerOfThree {
    public static void main(String[] args){
        boolean flag = new IsPowerOfThree().isPowerOfThree(9);
        System.out.println(flag);
        //System.out.println(2%3);
    }
    public boolean isPowerOfThree(int n) {
        // 通过循环方式调用
        /*if (n == 1){
            return true;
        }
        else if (n == 0)
            return false;
        else if (n % 3 == 0)
            return isPowerOfThree(n / 3);
        else
            return false;*/
        // 3的20次方 超出了int类型的范围，所以取3的19次方
        return (n>0 && 1162261467%n==0);
    }
}
