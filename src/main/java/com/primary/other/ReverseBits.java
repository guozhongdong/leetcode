package com.primary.other;

/**
 * @author gzd
 * @create 2018-06-11 19:12
 * @desc
 **/
public class ReverseBits {

    public static void main(String[] args){
        int s = new ReverseBits().reverseBits(43261596);
        System.out.println(s);
    }

    public int reverseBits(int n) {

        String s = Integer.toBinaryString(n & 0xffffffff);
        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        String s1 = sb.append(s).reverse().toString();
        System.out.println(sb.reverse().toString());
        System.out.println(s1);
        Integer jk = Integer.valueOf(s1,2);
        System.out.println(jk);
        return jk;     //转换成十进制
    }
}
