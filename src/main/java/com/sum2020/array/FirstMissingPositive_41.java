package com.sum2020.array;

/**
 * @author gzd
 * @date 2020/2/11 下午8:45
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * 参考leetcode题解
 * 根据桶排序的方法，查找n的区间内的正数，查找每个索引i对应的正整数，正整数应该是i+1，如果对应上了，就
 * 表示是有的，如果索引i跟i+1的正整数没有对上，则返回i+1 的正整数，
 * 桶排序，抽屉法查找元素，使用O(n)的时间复杂度
 *
 * 思路：
 */
public class FirstMissingPositive_41 {

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        int n = new FirstMissingPositive_41().firstMissingPositive(nums);
        System.out.println(n);
    }

    public int firstMissingPositive(int[] nums) {

        if (nums == null){
            return 0;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 满足在指定范围内，并且没有放到正确的位置，交换位置
            while (nums[i]> 0 && nums[i] < len && nums[nums[i]-1] != nums[i]){
                swap(nums,nums[i]-1,i);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i+1){
                return i+1;
            }
        }
        return len+1;
    }

    public void swap(int[] nums ,int index1,int index2){
        int num = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = num;
    }
}
