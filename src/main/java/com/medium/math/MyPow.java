package com.medium.math;

/**
 * @author gzd
 * @create 2018-07-09 21:44
 * @desc
 **/
public class MyPow {

    public static void main(String[] args){
       double d =  new MyPow().myPow(3,3);
       System.out.println(d);
        System.out.println(1/2);
        //System.out.println(Integer.MAX_VALUE);
    }
    public double myPow(double x, int n) {
        /*if (n == 0){
            return 1;
        }
        if (n < 0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x,n/2):x*myPow(x*x,n/2);*/
        if (n == 0) return 1;
        double half = myPow(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else if (n > 0)
            return half * half * x;
        else
            return half * half / x;

        //return sum;
    }
}
