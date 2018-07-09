package com.medium.math;

/**
 * @author gzd
 * @create 2018-07-09 21:10
 * @desc 本质是26进制 转十进制，
 *
 **/
public class TitleToNumber {

    public static void main(String[] args){
        int sum = new TitleToNumber().titleToNumber("ZY");
        System.out.println(('Z' - 'B' +1));
        //System.out.println(sum);
        //System.out.println(new Integer('A'));
    }

    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum *26 + (s.charAt(i) - 'A' +1);
        }
        return sum;
    }
}
