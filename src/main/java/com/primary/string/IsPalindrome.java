package com.primary.string;

/**
 * @author gzd
 * @create 2018-06-04 9:13
 * @desc 思路：先把符号去掉，过滤空格，
 **/
public class IsPalindrome {

    public static void main(String[] args){
        boolean flag = new IsPalindrome().isPalindrome("0P");
        System.out.println(flag);
    }

    public boolean isPalindrome(String s) {
        char[] ch = s.toLowerCase().replaceAll("[^0-9a-z]","").toCharArray();
        System.out.println(new String(ch));
        //int i = ch.length-1;
        for (int i = 0; i <ch.length ; i++) {
            if (ch[i] != ch[ch.length-1-i]){
                return false;
            }
        }
        return true;
    }

}
