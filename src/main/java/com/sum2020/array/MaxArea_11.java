package com.sum2020.array;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/1/6 19:42
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 暴力法：遍历两次，取一个最大值,此思路暂时没有做出来，参考题解
 * 思路2：双指针，前后同时取数，取一个最大面积值，
 */
public class MaxArea_11 {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int area = new MaxArea_11().maxArea(nums);
        System.out.println(area);
    }
    public int maxArea(int[] height) {
        int len = height.length;
        int area = Integer.MIN_VALUE;
        int left = 0;
        int right = len-1;
        while (left < right){
            if (height[left] > height[right]){
                area = Math.max(height[right] * (right-left),area);
                right--;
            }else{
                area = Math.max(height[left] * (right-left),area);
                left++;
            }
        }

        return area;
    }
}
