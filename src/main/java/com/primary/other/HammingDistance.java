package com.primary.other;

/**
 * @author gzd
 * @create 2018-06-11 13:46
 * @desc
 **/
public class HammingDistance {

    public static void main(String[] args){
        int c = new HammingDistance().hammingDistance(3,5);
        System.out.println(c);
        System.out.println(7 & 5);
    }

    public int hammingDistance(int x, int y) {

        /*return Integer.bitCount(x ^ y);*/
        int val = x ^ y ;
        int count = 0;
        while (val >0 ){
            val &= val -1;
            count++;
        }
        return count;
    }
}
