package com.medium.sortAndsearch;

/**
 * @author gzd
 * @create 2018-08-07 21:13
 * @desc 数组中的第K个最大元素
 * 思路:先排序在查找
 **/
public class FindKthLargest {

    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4};
        int n = new FindKthLargest().findKthLargest(nums,2);
        System.out.println(n);
    }

    public int findKthLargest(int[] nums, int k) {

        if (nums == null ){
            return 0;
        }
        int temp = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i] < nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        //System.out.println("");
        return nums[k-1];
    }
}
