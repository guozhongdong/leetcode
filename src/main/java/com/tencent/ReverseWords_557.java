package com.tencent;

import com.byteDance.ReverseWords;

/**
 * @author gzd
 * @date create in 2019/2/13 21:04
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 思路:以空格截取单词，反转每一个单词，然后拼接到一起
 *
 **/
public class ReverseWords_557 {

    public static void main(String[] args){
        String result = new ReverseWords_557().reverseWords("Let's take LeetCode contest");
        System.out.println(result);
    }

    public String reverseWords(String s) {
        StringBuilder sb1 = new StringBuilder();
        String[] strs = s.split(" ");
        for (int i = 0; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder(strs[i]);
            String s1 = String.valueOf(sb.reverse());
            sb1.append(s1).append(" ");
        }
        return sb1.toString().trim();
    }
}
