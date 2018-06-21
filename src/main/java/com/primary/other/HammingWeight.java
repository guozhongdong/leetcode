package com.primary.other;

/**
 * @author gzd
 * @create 2018-06-11 9:11
 * @desc 位1的个数
 **/
public class HammingWeight {

    public static void main(String[] args){
        new HammingWeight().hammingWeight(65536);
    }
    public int hammingWeight(int n) {
        if (n > Integer.MAX_VALUE || n<Integer.MIN_VALUE){
            return -1;
        }
        int i = n & 0xffffffff;
        String s = Integer.toBinaryString(i);
        int count = 0;
        for (int j = 0; j < s.length() ; j++) {
            if(s.charAt(j) == '1'){
                count++;
            }
        }
        System.out.println(count);
        return count;
        /*if (n == 0) return 0;
        int  result = 1;
        while (n > 2) {
            result += n % 2;
            n = (int) Math.floor(n / 2);
        }
        System.out.println(result);
        return result;*/
    }
}
