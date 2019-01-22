package com.random;

/**
 * @author gzd
 * @date create in 2019/1/22 20:43
 *
 * 长度最小的子数组
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 优解：滑动窗口，左右同时开始计算
 **/
public class MinSubArrayLen_209 {

    public static void main(String[] args){
        int[] array = {2,3,1,2,4,3};
        int n = new MinSubArrayLen_209().minSubArrayLen(7,array);
        System.out.println(n);
    }
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int num = Integer.MAX_VALUE;
        int j = -1;
        int i = 0;
        int total = 0;
        while (i < nums.length){
            if (j+1 < nums.length && total < s){
                j+=1;
                total += nums[j];
            }else {
                total -= nums[i];
                i+=1;
            }
            if (total >= s){
                num = Math.min(num,j-i+1);
            }
        }

        return num == Integer.MAX_VALUE ? 0 : num;
    }
}
