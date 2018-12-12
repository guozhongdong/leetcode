package com.byteDance.array;

/**
 * @author gzd
 * @create 2018-12-12 19:40
 * @desc 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * 示例：
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 思路：遍历数组，做一个计数位，找到最大的数返回
 *
 **/
public class FindLengthOfLCIS {

    public static void main(String[] args){
        int[] array = {};
        int n =  new FindLengthOfLCIS().findLengthOfLCIS(array);
        System.out.println(n);
    }
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length==0){
            return 0;
        }
        int count = 0;
        int n = 1;
        //int arr1 = nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]<nums[i+1]){
                n++;
            }else{
                count = Math.max(count,n);
                n = 1;
            }
        }
        count = Math.max(count,n);
        return count;
    }
}
