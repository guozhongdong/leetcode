package com.sum2020.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzd
 * @date 2020/4/11 下午1:51
 * 118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 思路：每一行的第一个数和最后一个数都为1
 * 动态规划：按题解，每个数等于它左上角加右上角的和。
 *
 *
 */
public class Generate_118 {

    public static void main(String[] args) {

        System.out.println(new Generate_118().generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();


        for (int i = 0; i < numRows; i++) {
            if (i == 0){
                List<Integer> list = new ArrayList<>();
                list.add(1);
                result.add(list);
            }else if (i == 1){
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(1);
                result.add(list);
            }else{
                result.add(geneta(result.get(i-1),i));
            }
        }

        return result;
    }
    /**
     * 传递一个上一个行的参数和这一行需要添加的数字个数
     * */
    public List<Integer> geneta(List<Integer> list,int m){
        List<Integer> hang = new ArrayList<>();
        hang.add(1);
        // 排除第一个数和最后一个数
        for (int i = 1; i < m; i++) {
            hang.add(list.get(i-1)+list.get(i));
        }
        hang.add(1);
        return hang;
    }
}
