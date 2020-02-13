package com.sum2020.array;

/**
 * @author gzd
 * @date 2020/2/12 下午2:29
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 思路:
 * 1、题意下标上对应的数 是最大的长度，也就是说可以选择最大长度内的任意长度。
 * 2、参考题解，贪心算法，局部最优，定义边界值，然后在 跳跃的区间内，找能跳的最大的步数，也就是最大的值
 *
 *
 *
 */
public class JumpII_45 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int step = new JumpII_45().jump(nums);
        System.out.println(step);
    }

    public int jump(int[] nums) {
        int maxPrevious = 0;
        //步数
        int steps = 0;
        int end = 0 ;
        for (int i = 0; i < nums.length-1; i++) {
            maxPrevious = Math.max(maxPrevious,nums[i]+i);
            //等于边界值，说明这一步里面的都走完了，更新边界，取一个边界里面的值，
            if ( i == end){
                end = maxPrevious;
                steps++;
            }

        }


        return steps;
    }


}
