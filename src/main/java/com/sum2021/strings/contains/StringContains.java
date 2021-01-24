package com.sum2021.strings.contains;

import com.primary.other.HammingDistance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author guozhongdong
 * @date 2021/1/21 19:51
 *
 * 给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。
 * 请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
 */
public class StringContains {


    public static void main(String[] args) {
        String str = "ABCD";
        String str2 = "BCF";

        System.out.println(new StringContains().contain1(str, str2));
        System.out.println(new StringContains().contain2(str, str2));
    }

    // 解法一  暴力比较法

    public boolean contain1(String a,String b){

        for (int i = 0; i < b.length(); ++i) {
            int j;
            for (j = 0;  j< a.length() && (a.charAt(j) != b.charAt(i)); ++j) {

                if (j >= b.length()){
                    return false;
                }

            }
        }

        return true;
    }
    /**
     * 计数排序法
     * 使用hash表存放字符的下标
     * 时间复杂度
     * O(n+m)
     *
     * */
    public boolean contain2(String a,String b){
        Set<Character> map = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            map.add(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            if (!map.contains(b.charAt(i))){
                return false;
            }
        }

        return true;
    }


}
