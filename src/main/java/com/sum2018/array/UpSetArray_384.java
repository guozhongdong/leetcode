package com.sum2018.array;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author gzd
 * @date 2019/6/10 下午1:36
 *
 * 打乱数组
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 * ==========================================
 * 提交记录发现，一年前做过这个题目，当时是没有做出来，现在用普通的方法做出来了，但是用时太长317ms，还有提升空间。
 */
public class UpSetArray_384 {
    private int[] nums = null;
    Random random = new Random();
    public UpSetArray_384(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {

        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> list = new ArrayList<>();
        int[] shuffleNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int count = 0;
        while (list.size() > 0){

            int n = random.nextInt(list.size());
            shuffleNums[count] = list.get(n);
            list.remove(n);
            count ++;
        }

        return shuffleNums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        UpSetArray_384 upSetArray_384 = new UpSetArray_384(nums);
        upSetArray_384.shuffle();
        upSetArray_384.shuffle();
        //upSetArray_384.reset();
    }
}
