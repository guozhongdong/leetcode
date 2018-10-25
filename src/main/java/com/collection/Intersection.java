package com.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gzd
 * @create 2018-10-25 11:13
 * @desc 给定两个数组，编写一个函数来计算它们的交集。
 **/
public class Intersection {

    public static void main(String[] args){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] nums = new Intersection().intersection(nums1,nums2);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] nums = {};
        Set<Integer> set = new HashSet<>();
        if (nums1 == null || nums2 == null){
            return nums;
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]){
                    set.add(nums1[i]);
                    break;
                }
            }
        }

        nums = new int[set.size()];
        int k = 0;
        for (Integer e : set){
           nums[k] = e;
           k++;
        }
        return nums;
    }

}
