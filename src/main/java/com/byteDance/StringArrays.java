package com.byteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gzd
 * @create 2018-12-06 21:33
 * @desc 字符串排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 思路：遍历字符数组，每次选取一个元素作为结果的第一个元素，后面的全排列，递归获取。
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * =======================================================
 * 以上思路有问题， 忽略了字符串的大小问题，全排列思路不可取
 * =======================================================
 * 新思路：不必要全排列，假如s1的字符串长度是3，为aab，则只需要在s2中，任意找三个连续的字符，其中包括两个a，一个b，即可满足。
 * 另外字符比较，可用数字代替
 * 具体实现方法，还需要研究
 **/
public class StringArrays {

    private static  List<String> list = new ArrayList<>();
    public static void main(String[] args){

       boolean boon =  new StringArrays().checkInclusion("ab","bsfanbakk");
       System.out.println(boon);

    }
    public boolean checkInclusion(String s1, String s2) {

        int slen = s1.length();
        int s2len = s2.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char c:s1.toCharArray()){
            c1[c-'a']++;
        }
        for (int i = 0; i < s2len; i++) {
            if (i >= slen){
                --c2[s2.charAt(i-slen)-'a'];
            }
            c2[s2.charAt(i)-'a']++;
            if (Arrays.equals(c1,c2)){
                return true;
            }

        }
        return false;
    }


}
