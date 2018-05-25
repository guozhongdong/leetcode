package com.gzd;

/**
 * @author gzd
 * @create 2018-05-25 13:42
 * @desc
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 **/
public class One {

    public static int[] twoSum(int[] nums, int target) {
        int[] arras = new int[2];
        for (int i=0;i<nums.length;i++){
            for (int k=i+1;k<nums.length;k++){
                if(nums[i]+nums[k] ==target){
                    arras[0] = i;
                    arras[1] = k;
                    return arras;
                }
            }
        }
        return arras;
    }

    public static void main(String[] args){
        int[] nums = {3,3};
        int target = 6;
        int[] nums2 = twoSum(nums,target);
        for (int i = 0; i <nums2.length ; i++) {
            System.out.println(nums2[i]);
        }

    }
}
