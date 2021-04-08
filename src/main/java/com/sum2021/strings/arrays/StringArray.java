package com.sum2021.strings.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozhongdong
 * @date 2021/3/15 20:54
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 例如输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符串
 *
 * abc、acb、bac、bca、cab 和cba。
 */
public class StringArray {

    /**
     * 全排列集合
     * */
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String str = "abc";
        char[] chars = str.toCharArray();
        new StringArray().calcAllPermutation(chars,0,str.length()-1);
        System.out.println(list);
    }

    /**
     * 递归解法
     * 固定一个首字符，其他两个全排列
     * 如 abc  固定a ，bc全排列 bc  cb;
     * 1、每一步找到当前字符串的全排列
     * 2、返回排列后的字符串，并记录
     * 3、终止条件是什么，str 是空
     * */
    public void calcAllPermutation(char[] chars,int from,int to){
        if (to <= 1){
            return;
        }
        if (from == to){
            StringBuilder s = new StringBuilder();
            for (int i = 0; i <= to ; i++) {
                s.append(chars[i]);
            }
            list.add(s.toString());
        }else {
            for (int j = from; j <= to ; j++) {
                swap(chars,j,from);
                calcAllPermutation(chars,from+1,to);
                swap(chars,j,from);
            }
        }
    }

    public void swap(char[] chars,int j,int from){
        char ch = chars[j];
        chars[j] = chars[from];
        chars[from] = ch;

    }

}
