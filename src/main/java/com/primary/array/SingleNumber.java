package com.primary.array;

/**
 * @author gzd
 * @create 2018-05-30 13:54
 * @desc 只出现一次的数字
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 思路：使用异或实现，0与任何数异或都是 它本身，一个数与它本身异或为0 ；
 * 延伸：交换两个数的值，不使用第三方变量.
 **/
public class SingleNumber {
    public static void main(String[] args){
        int[] nums = {2,1,2,3,4,3,4};
      int s = new SingleNumber().singleNumber(nums);
        System.out.println(6^5);
        System.out.println(s);
    }

    public int singleNumber(int[] nums) {

        // invalid check
        if (nums.length == 0) {
            return -1;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
