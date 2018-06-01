package com.primary.string;

/**
 * @author gzd
 * @create 2018-05-31 22:41
 * @desc 反转字符串
 **/
public class ReverseString {

    public static void main(String[] args){
     new ReverseString().reverseString("hello");
    }
    public String reverseString(String s) {
        // 解法1：
        /*char[] ch = s.toCharArray();
        int len = ch.length-1;
        int i = 0;
        while (i<len){
            char s1 = ch[i];
            ch[i] = ch[len];
            ch[len] = s1;
            i++;
            len--;
        }
        System.out.println(new String(ch));
        //return "";
        return new String(ch);*/

        //解法2：使用StringBuffer 自带的api方法
        ;


        return "";
    }
}
