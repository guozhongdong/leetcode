package com.primary.other;

/**
 * @author gzd
 * @create 2018-06-15 9:12
 * @desc:有效的括号
 * 思路：
 **/
public class ValidBracket {

    public static void main(String[] args){
        new ValidBracket().isValid("(){}[]");
    }

    public boolean isValid(String s) {
        int len = s.length();
        boolean flag = false;
        for (int i = 1; i < len; i+=2) {

            if (s.charAt(i) ==')' && s.charAt(i-1) =='('){
                flag = true;
            }
            if (s.charAt(i) =='}' && s.charAt(i-1) =='{'){
                flag = true;
            }
            if (s.charAt(i) ==']' && s.charAt(i-1) =='['){
                flag = true;
            }
        }
        System.out.println(flag);
        return flag;
    }

}
