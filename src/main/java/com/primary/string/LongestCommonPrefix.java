package com.primary.string;

import java.util.Arrays;

/**
 * @author gzd
 * @create 2018-06-06 13:27
 * @desc 最长公共前缀
 * 思路：取出所有的字符串
 **/
public class LongestCommonPrefix {

    public static void main(String[] args){
        String[] strs = {"a"};
        String s = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(s);
    }
    public String longestCommonPrefix(String[] strs) {
        /*System.out.println(strs.length);
        System.out.println(strs[0].length());
        if (strs == null || strs.length==0 ){
            return "";
        }
        int j = 0;
        int result = 200;
        if (strs[0].length() > 0){
            for (int i = 1; i < strs.length; i++) {
                String str = strs[0];
                int temp = 0;

                    if (str.length() > strs[i].length()){

                        for (int k = 0; k < strs[i].length() ; k++) {
                            if (str.charAt(k) != strs[i].charAt(k)){
                                break;
                            }
                            temp++;
                        }
                    }else{
                        for (int k = 0; k < str.length() ; k++) {
                            if (str.charAt(k) != strs[i].charAt(k)){
                                break;
                            }
                            temp++;
                        }

                    }
                    result = Math.min(result,temp);


               // System.out.println(result);
            }
        }else {
            return "";
        }
        System.out.println(result);
        if (result == 0){
            return "";
        }else{
            char[] ch = new char[result];
            for (int i = 0; i < result; i++) {
                ch[i] = strs[0].charAt(i);
            }
            System.out.println(new String(ch));
            return new String(ch);
        }
        //System.out.println(result);
        //Sys   tem.out.println(j);*/
        if (strs == null || strs.length==0 ){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        String s1 = strs[0];  //取第一个
        String s2 = strs[strs.length-1]; // 取最后一个
        for (int i = 0; i < s1.length() ; i++) {
            if (s2.length()> i && s1.charAt(i) == s2.charAt(i) ){
                sb.append(s1.charAt(i));
            }else{
                return sb.toString();
            }
        }
        //先把数组进行排序，拿第一个串 跟最后一个串进行比较，有公共的则输出，没有公共的就返回“”值
        return sb.toString();


    }

    public String getPrifix(){

        return "";
    }
}
