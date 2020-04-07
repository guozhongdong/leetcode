package com.sum2020.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gzd
 * @date 2020/4/7 下午9:04
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 第一思路：能暴力出来的，先不考虑其他解。先把第一个数的子集找出来，然后在往后遍历..----没整出来
 *
 * 其他思路：递归，设置一个空子集，每一次往子集里添加元素，知道数组的元素添加完
 *
 */
public class Subsets_78 {
    public static void main(String[] args) {
        //int[] nums = {1,2,3};
        //int[] nums = {0};
        int[] nums = {1,2};

        System.out.println(new Subsets_78().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length ; i++) {

            //第一个是空集
            int size = result.size();
            for (int j = 0; j < size ; j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }

        }
        return result;
    }

    private  void addNum(){

    }

    /**
     * 牛人解法
     * 位运算
     * 留着刺激大脑
     * */
    public static List<List<Integer>> binaryBit(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
        }
        return res;
    }

    /**
     * 优秀解法二
     * 递归回溯法
     *
     * */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


}
