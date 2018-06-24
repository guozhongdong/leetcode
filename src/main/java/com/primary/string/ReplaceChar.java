package com.primary.string;

/**
 * @author gzd
 * @create 2018-06-24 21:12
 * @desc: 提交一个工具类，替换一个字符
 **/
public class ReplaceChar {
    public static void main(String[] args){
        String s = new ReplaceChar().replaceSpecialChar("and cust.label > 12.00");
        System.out.println(s);
    }
    public String replaceSpecialChar(String str){
        if (str == null){
            return null;
        }
        String result = null ;
        char[] charArray = str.toCharArray();
        int len = charArray.length;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '.' && i+1 < len){
                if (Character.isDigit(charArray[i-1]) && Character.isDigit(charArray[i-1])){
                    charArray[i] = '#';
                }else{
                    charArray[i] = '*';
                }
            }
        }
        result = new String(charArray);
        result = result.replaceAll("#",".").replaceAll("\\*","__");
        return result;
    }
}
