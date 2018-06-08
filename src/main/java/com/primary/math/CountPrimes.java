package com.primary.math;

/**
 * @author gzd
 * @create 2018-06-08 13:41
 * @desc 统计所有小于非负整数 n 的质数的数量。
 * 质数：只能被1和它本身整除
 * 思路：筛选法
 **/
public class CountPrimes {

    public static void main(String[] args){
        int n = new CountPrimes().countPrimes(10);
        System.out.println(n);
    }
    public int countPrimes(int n) {
       boolean[] isPrimes = new boolean[10];
        for (int i = 2; i < n ; i++) {
            isPrimes[i] = true;
        }
        for (int i = 2; i*i < n  ; i++) {
            if (!isPrimes[i])
                continue;
            for (int j = i * i; j < n; j += i) {
                isPrimes[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n ; i++) {
            if (isPrimes[i])
                count++;
        }
        return count;
    }
}
