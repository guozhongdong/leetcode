package com.primary.string;

/**
 * @author gzd
 * @create 2018-06-01 13:22
 * @desc
 **/
public class ReverseInt {

    public static void main(String[] args){
        int i = 1290;
        new ReverseInt().reverse(i);
    }

    public int reverse(int x) {
        //思路1：用字符串反转法
        /*String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        long result = 0;
        if (s1.endsWith("-")){
            result = -Long.valueOf(s1.substring(0,s1.length()-1));
        }else{
            result = Long.valueOf(s1);
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        System.out.println(result);
        return (int)result;*/
        // 思路2：用除10 取模法
        long result = 0;
        while (x != 0){
            result = result*10 + x%10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result< Integer.MIN_VALUE)
            return 0;
        return (int) result;
    }
}
