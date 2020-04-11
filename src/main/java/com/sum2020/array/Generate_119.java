package com.sum2020.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzd
 * @date 2020/4/11 下午2:25
 *
 * 119.杨辉三角II
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * 思路：I 的 题解是需要遍历两次 num，时间复杂度是 O(n^2) n是行数
 * 暴力解题思路与 I 一样，把每一行都算出来，然后直接返回，
 *
 * 要求 常数解，则上述方法不可使用
 * 参考第一个解法的特殊解法，下一行，等于上一行的错位补0相加
 *
 */
public class Generate_119 {

    public static void main(String[] args) {

    }


    /**
     * 参考网上题解
     * */
    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<Integer>());
        list.get(0).add(1);
        for(int row = 1;row<=rowIndex;row++) {
            List<Integer> sublist = new ArrayList<Integer>();
            List<Integer> prev = list.get(row-1);
            sublist.add(1);
            for(int i = 1;i<row;i++) {
                sublist.add(prev.get(i-1)+prev.get(i));
            }
            sublist.add(1);
            list.add(sublist);
        }
        return list.get(rowIndex);

    }
}
