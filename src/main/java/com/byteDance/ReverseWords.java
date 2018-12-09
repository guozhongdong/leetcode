package com.byteDance;

/**
 * @author gzd
 * @create 2018-12-09 20:13
 * @desc 给定一个字符串，逐个翻转字符串中的每个单词。
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 思路1: 采用String 的api方法split()，拿空格分组，之后拼接成一个完整的字符串（已验证）
 * 思路2：倒序遍历字符，拼接字符串
 **/
public class ReverseWords {

    public static void main(String[] args){
       String str =  new ReverseWords().reverseWords("the  sky  is blue");
       System.out.println(str);
    }
    public String reverseWords(String s) {
        if (s==null || s.length()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");
        if (str.length>0){
            for (int i = str.length-1; i >=0; i--) {
                if ( !"".equals(str[i])){
                    sb.append(str[i]).append(" ");
                }
            }
            return sb.toString().trim();

        }
        //方法2，字符遍历法
        return "";
    }
}
