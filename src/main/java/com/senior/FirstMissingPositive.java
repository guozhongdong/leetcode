package com.senior;

/**
 * @author gzd
 * @create 2018-10-31 20:28
 * @desc 第一个缺失的正数
 * 要求：时间复杂度为O(n),并且只能使用常数级别的空间
 * 思路："先排序，取出最小的正整数" 思路错误
 * 利用数组下标的常数值
 *
 **/
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]){
                int index = nums[i];
                nums[i] = nums[index-1];
                nums[index -1] = index;
            }else {
                i++;
            }

        }
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
    public static void main(String[] args){
        int[] nums = {7,8,9,11,12};
        int n = new FirstMissingPositive().firstMissingPositive(nums);
        System.out.println(n);
    }
}
