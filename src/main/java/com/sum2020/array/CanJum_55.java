package com.sum2020.array;

/**
 * @author gzd
 * @date 2020/2/13 下午2:42
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 思路：算法，动态规划，贪心算法，
 *
 * 思路2：一个格子，一个格子的跳，把能跳跃到最远的距离记录下来，最终跟 数组的长度进行比较，当跳跃的距离大于等于
 * 数组的长度时，就说明可以跳出去。
 */
public class CanJum_55 {

    public static void main(String[] args) {
        int[] nums = {1,2,0,1};
        System.out.println(new CanJum_55().canJump(nums));

    }
    public boolean canJump(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length-1; i++) {

            if (i>num){
                return false;
            }
            num = Math.max(num,nums[i]+i);

        }
        return true;
    }
}
