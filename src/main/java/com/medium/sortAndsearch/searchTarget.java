package com.medium.sortAndsearch;

/**
 * @author gzd
 * @create 2018-08-10 20:37
 * @desc 搜索旋转排序数组
 * 4,5,6,7,0,1,2
 * 思路：前提是排序数组，旋转之后成为两个递增序列，而且第一个递增序列肯定比第二个大
 * 要求时间复杂度为 O(logn)
 * 二分法前提是 已经排序了的数组
 **/
public class searchTarget {

    public static void main(String[] args){
        int[] nums = {3,1};
        int n = new searchTarget().search(nums,1);
        System.out.println(n);
    }

    public int search(int[] nums, int target) {
        if (nums == null){
            return  -1;
        }
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid =start +  (end  - start)/2;
            if (target == nums[mid]) { // 则到第二个递增序列里找
                return mid;
            }
            if (nums[mid] >= nums[start]){ //如果成立，说明mid 和start 在同一个递增数组上

                if (nums[start] <= target && target < nums[mid]){ // 成立，说明target在第一个递增数组里
                    end = mid -1 ; // 使用原始方法遍历
                }
                else{
                    start = mid +1 ;
                }
            }else{
                if (nums[mid] <= target && target <= nums[end]){
                    start = mid + 1 ;
                }else {
                    end = mid==0?mid:mid-1;
                }
            }

        }
        return -1;
    }
}
