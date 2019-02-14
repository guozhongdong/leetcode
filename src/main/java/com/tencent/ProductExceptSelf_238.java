package com.tencent;

/**
 * @author gzd
 * @date create in 2019/2/14 21:51
 *
 * 除自身以外数组的乘积
 *
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 时间复杂度较高，有待优化！
 **/

public class ProductExceptSelf_238 {

    public static void main(String[] args){
        int[] array = {1,2,3,4};
        int[] result = new ProductExceptSelf_238().productExceptSelf(array);

    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int i = 0;
        while (i < nums.length){
            int sum = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j){
                    sum = sum * nums[j];
                }
            }
            result[i] = sum;
            i++;
        }

        return result;
    }
}
