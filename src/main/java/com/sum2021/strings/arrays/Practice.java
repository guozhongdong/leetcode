package com.sum2021.strings.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozhongdong
 * @date 2021/3/16 20:31
 *
 * 已知字符串里的字符是互不相同的，现在任意组合，比如ab，则输出aa，ab，ba，bb，编程按照字典序输出所有的组合。
 *
 * 分析：非简单的全排列问题（跟全排列的形式不同,abc全排列的话，只有6个不同的输出）。
 * 本题可用递归的思想，设置一个变量表示已输出的个数，然后当个数达到字符串长度时，就输出。
 *
 * 1、每一步要干的事，每次找一个字符，
 *
 * 2、返回给上一层的是当前字符
 *
 * 终止条件：达到长度跳出循环，
 */
public class Practice {

    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        char[] charts = "abc".toCharArray();
        char[] temp = new char[charts.length];
        new Practice().perm(temp,0,charts,charts.length);
        System.out.println(list);
    }

    /**
     *
     * 查找字符全排列
     * @param result 保存结果集
     * @param wei 结果数组的下标
     * @param chs 原数组
     * @param size 原数组大小
     * */
    public void perm(char[] result,int wei,char[] chs,int size){

        //1、跳出递归的条件
        if (wei == size){
            list.add(new String(result));
            return;
        }else{
            for (int i = 0; i < size; i++) {
                result[wei] = chs[i];
                perm(result,wei+1,chs,size);
            }
        }
    }


}
