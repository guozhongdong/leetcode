package com.byteDance.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzd
 * @create 2018-12-14 22:31
 * @desc 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 思路：不对的思路 是求出所有的排列，然后按k去取，
 * 正确的思路：列出 n 个数字的每一种可能， 然后 按k去取对应数字，
 * 求出n的阶乘的个数，
 * 暂时不是很理解，先记录在此，以便日后复习使用
 *
 *
 **/
public class GetPermutation {

    public static void main(String[] args){
       String str =  new GetPermutation().getPermutation(3,3);
       System.out.println(str);
    }
    public String getPermutation(int n, int k) {

        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        //阶乘
        int tiems = n-1;
        k = k-1;
        while (tiems >= 0){

            int sum = 1;
            for (int i = 1; i <= tiems; i++) {
                sum *= i;
            }
            int indexList = k/sum; //寻找第一个数
            sb.append(list.get(indexList));
            list.remove(indexList);
            k = k%sum;

            tiems--;
        }

        return sb.toString();
    }
    public void getPermutationUp(int[] array){

    }
}
