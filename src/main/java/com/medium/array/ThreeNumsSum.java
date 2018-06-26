package com.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gzd
 * @create 2018-06-25 13:33
 * @desc：求三个数的和
 *
 **/
public class ThreeNumsSum {

    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = new ThreeNumsSum().threeSum(nums);
        System.out.println(list);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        //先对数组进行排序，
        if (nums != null && nums.length>2){
            Arrays.sort(nums);
            // i表示取的第i 个数作为结果
            for (int i = 0; i < nums.length-2 ; ) {
                //j 表示 第二个数的起始位置
                int j = i+1;
                // k 表示 第三个数的结束位置
                int k = nums.length-1;
                while (j < k){ // 开始遍历 第二个数和第三个数的和
                    if (nums[j] + nums[k] == -nums[i]){
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        // 移动到下一个位置，求下一组解
                        k--;
                        j++;
                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }else if (nums[j] + nums[k] > -nums[i]){
                        k--;
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }else{
                        j++;
                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                    }

                }
                i++;
                // 从左向右找第一个与之前处理的数不同的数的下标
                while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                    i++;
                }
            }
        }

        return result;
    }
}
