package com.medium.other;

/**
 * @author gzd
 * @create 2018-07-11 22:34
 * @desc 求两个数的和，要求不能使用+ -
 * 思路：使用异位 求和
 **/
public class GetSum {

    public static void main(String[] args){
        /*int num = new GetSum().getSum(7,9);
        System.out.println(num);*/
        System.out.println(8&8);
    }
    public int getSum(int a, int b) {

        int res = 0;
        //不进位的加和
        int xor = a^b;

        //进位和
        int forward = (a&b)<<1;
        if(forward != 0){
            res = getSum(xor,forward);//循环处理 进位和+不进位加和
        }else {
            res = xor;
        }
        return res;
    }
}
