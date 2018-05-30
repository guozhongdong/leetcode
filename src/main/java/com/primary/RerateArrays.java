package com.primary;

/**
 * @author gzd
 * @create 2018-05-29 22:55
 * @desc 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 思路：旋转数组
 **/
public class RerateArrays {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);  //翻转前k个值
        reverse(nums,k,nums.length-1); // 翻转剩下的 nums.length -K 的值
        for (int i = 0; i < nums.length ; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
