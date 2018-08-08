package com.medium.sortAndsearch;

/**
 * @author gzd
 * @create 2018-08-08 21:19
 * @desc 在排序数组中查找元素的第一个和最后一个位置
 * 算法时间复杂度必须是 O(log n) 级别。
 **/
public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        /*int[] nums1 = new SearchRange().searchRange(nums, 8);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }*/
        int[] result = new int[2];
        result[0] = searchRange2(nums,8);
        result[1] = findLast(nums,8);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" " );
        }
    }

    //二分法查找
    //正序
    // 思路：先第一次 二分法找出目标值，然后左右遍历
    public int[] searchRange(int[] nums, int target) {
        /*int i = 0;
        int j = nums.length-1;
        int[] n = new int[]{-1,-1};
        while (i <= j){
            int mid = (i+j)/2;
            if (nums[mid] == target){
                while (mid >= i && nums[mid] == target){
                    mid -- ;
                }
                n[0] = mid + 1;
                mid = (i + j)/2;
                while (mid <= j && nums[mid] == target){
                    mid ++;
                }
                n[1] = mid - 1 ;
                break;

            }else if (nums[mid] > target){
                j = mid -1 ;
            }else{
                i = mid + 1 ;
            }

        }
        return n;*/
        /**/
        return null;
    }

    public static  int searchRange2(int[] nums, int target) {
        int temp = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) {
                temp = mid;
            }
        }
        return temp;
    }
    public static  int findLast(int[] nums, int target) {
        int temp = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid -1 ;
            }
            if (nums[mid] == target) {
                temp = mid;
            }
        }
        return temp;
    }
}