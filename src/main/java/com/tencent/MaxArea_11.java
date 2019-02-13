package com.tencent;

/**
 * @author gzd
 * @date create in 2019/2/13 10:12
 * 盛最多水的容器
 * 说明: 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 *      垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 *      找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 暴力解法
 * 思路:考虑所有的线段组合，组成的面积
 *
 *
 *
 **/
public class MaxArea_11 {

    public static void main(String[] args){
        int[] array = {1,8,6,2,5,4,8,3,7};
        int n = new MaxArea_11().maxArea(array);
        System.out.println(n);
    }

    public int maxArea(int[] height) {
        //官方解法一: 暴力解法
        /*int max = 0;
        for (int i = 0; i < height.length ; i++) {
            for (int j = i+1; j < height.length; j++) {
                max = Math.max(max,Math.min(height[i],height[j]) * (j-i));
            }
        }
        return max;*/
        //官方解法二: 移动指针法
        int maxarea = 0 ,low = 0 ,r = height.length-1;
        while (low < r){
           //计算线段间的面积
           maxarea = Math.max(maxarea,Math.min(height[low],height[r]) * (r-low));
           if (height[low] < height[r]){
               low ++;
           }else{
               r--;
           }
        }
        return maxarea;

    }
}
