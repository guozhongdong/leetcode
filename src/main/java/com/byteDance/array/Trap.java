package com.byteDance.array;

/**
 * @author gzd
 * @create 2018-12-18 22:33
 * @desc接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 思路：参考网上
 * 找出最大的柱子高度，然后分别从左遍历，找出左边的最大值，假如遇到比它小的就可以装水，
 * 遇到比它大的 交换位置往后遍历
 **/
public class Trap {

    public static void main(String[] args){
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        new Trap().trap(nums);
    }

    public int trap(int[] height) {
        if (height ==null || height.length ==0){
            return 0;
        }
        int maxIndex = 0;
        int maxMum = 0;
        for (int i = 0; i < height.length; i++) {
            if (maxMum <= height[i]){
                maxMum = height[i];
                maxIndex = i;
            }

        }
        // 从开始遍历
        int maxLeft = 0;
        int sum = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (maxLeft <= height[i]){
                maxLeft = height[i];
            }else {
                sum += maxLeft -height[i];
            }
        }
        int maxRight = 0;
        for (int i = height.length-1; i > maxIndex; --i) {
            if (maxRight <= height[i]){
                maxRight = height[i];
            }else{
                sum += maxRight - height[i];
            }
        }
        return sum;
    }
}
