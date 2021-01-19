package com.sum2021.strings.practice;

import java.util.Stack;

/**
 * @author guozhongdong
 * @date 2021/1/14 21:22
 *
 * 3、单词翻转。输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，
 * 句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。
 * 例如，输入“I am a student.”，则输出“student. a am I”。
 *
 * 不使用api
 *
 *两个栈，一个存放字符，一个存放空格，
 * 后面出栈，
 *
 *
 */
public class Demo3 {
    public static void main(String[] args) {
       String str = "I am a student.";
        System.out.println(new Demo3().getReversWords(str));
        System.out.println(Character.isSpaceChar(' '));
    }

    public String getReversWords(String str){
        //过渡每一个字符
        Stack<Character> ch1 = new Stack<>();

        //存最终的结果
        Stack<Character> ch2 = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isSpaceChar(str.charAt(i))){
                ch1.add(str.charAt(i));
            }else{
                while (!ch1.isEmpty()){
                    ch2.add(ch1.pop());
                }
                ch2.add(str.charAt(i));
            }
        }
        // 说明是最后一个单词
        while (!ch1.isEmpty()){
            while (!ch1.isEmpty()){
                ch2.add(ch1.pop());
            }
        }
        char[] res = new char[ch2.size()];
        int num = 0;
        while (!ch2.isEmpty()){
            res[num++] = ch2.pop();
        }


        return new String(res);
    }
}
