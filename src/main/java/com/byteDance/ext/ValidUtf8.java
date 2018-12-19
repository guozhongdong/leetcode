package com.byteDance.ext;

/**
 * @author gzd
 * @create 2018-12-19 20:42
 * @desc  UTF-8 编码验证
 *
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 *
 * 对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
 * 这是 UTF-8 编码的工作方式：
 *
 *    Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 *  注意：
 *    输入是整数数组。只有每个整数的最低 8 个有效位用来存储数据。这意味着每个整数只表示 1 字节的数据。
 *  data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
 *
 * 返回 true 。
 * 这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
 * 思路：阅读了题意，大致的意思 判断给定的整数数组里，符合不符合utf-8的编码标准，
 *      首先得判断第二个数的n 的个数，也就是连续的1 的个数，1的个数代表 字节数
 * 解题思路：
 * 一、既然标准就那几个，就一个一个的判断，首先还是判断1 的个数，将整数 进行位运算，先求标识字节，
 *  有几种可能，：1、整数向右平移五位，如果得到110，则说明是一个字节，做下记录，
 *              2、否则向右平移4为 ，如果得到1110 ，则说明是两个字节，做下记录，
 *              3、否则向右平移3为， 如果得到11110 ，则说明是三个字节，做下记录，
 *              都不满足，则平移7为，如果得到1，则不能当做标识字节，直接返回false；
 * 二、在非标识字节中，判断是都否是 10开头的，如果不是，肯定不是字节，返回false
 *    如果是 则 标识字节的个数 -1，知道标识字节的个数 ==0；则返回true
 **/
public class ValidUtf8 {

    public static void main(String[] args){
        int[] nums = {255};
        boolean bool = new ValidUtf8().validUtf8(nums);
        System.out.println(bool);
    }

    public boolean validUtf8(int[] data) {
        int n = 0;
        for (int i = 0; i < data.length; i++) {
            if (n == 0){
                if ((data[i] >> 5) == 0b110){
                    n = 1;
                }else if ((data[i] >> 4) == 0b1110){
                    n = 2;
                }else if ((data[i] >> 3) == 0b11110){
                    n = 3;
                }else if((data[i] >> 7) == 0b1){
                    return false;
                }
            }else{
                if ((data[i] >> 6) == 0b10) {
                    --n;
                }else {
                    return false;
                }

            }

        }


        return n==0;
    }

}
