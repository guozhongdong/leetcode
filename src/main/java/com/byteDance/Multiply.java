package com.byteDance;

/**
 * @author gzd
 * @create 2018-12-07 21:30
 * @desc 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
 *       它们的乘积也表示为字符串形式
 * 说明：
 *  num1 和 num2 的长度小于110。
 *  num1 和 num2 只包含数字 0-9。
 *  num1 和 num2 均不以零开头，除非是数字 0 本身。
 *  不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *  思路：开始自己没什么思路，想到了分位数去乘，但是没深入，最后参考网上教程
 *       一、首先两个数的结果的位数，肯定不大于两个数的总位数，因此可把两个位数和设置为数组的长度
 *       二、数组的每个下标，存放一个位数上的和，多的位进1，留给下一个位数相加。
 *       三、处理进位，
 **/
public class Multiply {



    public static void main(String[] args){
        String num = "123";
        String num2 = "456";
        int a = num.charAt(0)-'0';
      String str = new Multiply().multiply("9","99");
      System.out.println(str);
    }
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        // 创建一个int数组，分别存放各位上的和，且这个数组的位数最少等于 两个字符串的位数和
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[n+m];
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        //字符转换为数字
        for(int i =0; i<nums1.length; i++)
            nums1[i] -= '0';
        for(int i =0; i<nums2.length; i++)
            nums2[i] -= '0';

        // 从第一数的个位数开始，依次与第二个数相乘
        for (int i = 0; i < m ; i++) {
            int carry = 0; //设置进位

            for (int j = 0; j < n; j++) {

                res[i+j] += nums2[m-1-i]*nums1[n-1-j]+carry;
                carry = res[i+j]/10; //取进位的数字
                res[i+j] %= 10;      //获取特定位置的数字
            }
            //处理进位
            int k = i+n;
            while (carry > 0){
                res[k] += carry;
                carry = res[k]/10;
                res[k] = res[k]%10;
                k++;
            }
        }
        StringBuffer sb = new StringBuffer();
        int i = res.length-1;
        while (i >= 0 && res[i] == 0){
            i--;
        }
        while (i >= 0){
            sb.append(res[i]);
            i--;
        }
        return sb.toString();
    }

}
