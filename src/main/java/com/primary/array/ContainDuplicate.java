package com.primary.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gzd
 * @create 2018-05-30 13:38
 * @desc 给定一个整数数组，判断是否存在重复元素。
 **/
public class ContainDuplicate {

    public static void main(String[] args){
        int[] nums = {1,3,4,1};
        boolean flag = new ContainDuplicate().containsDuplicate(nums);
        System.out.println(flag);
    }

    public boolean containsDuplicate(int[] nums) {
        // 暴力解决算法，空间复杂度为O(n)
        /*for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i] == nums[j]){
                    return true;
                }
            }

        }
        return false;*/
        if (nums == null || nums.length==0)
            return false;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length ; i++) {
            set.add(nums[i]);
        }
        if (set.size() != nums.length)
            return true;
        return false;

    }
}
