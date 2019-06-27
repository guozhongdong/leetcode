package com.sum2018.sort;

/**
 * @author gzd
 * @date 2019/6/27 上午10:03
 *
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * // 目前使用的方法是 数字运算遍历
 * 可参考 快慢指针的方式
 */
public class FindDuplicate_287 {


    public static void main(String[] args) {

        int[] nums = {1,3,4,2,2};
        int n = new FindDuplicate_287().findDuplicate(nums);
        System.out.println(n);

    }
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < len; j++) {
                if ((temp ^ nums[j]) == 0){
                    return nums[j];
                }
            }
        }
        return 0;
    }
}
