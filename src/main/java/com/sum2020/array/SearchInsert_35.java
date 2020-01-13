package com.sum2020.array;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/1/6 12:12
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，
 * 返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 思路1:
 * 遍历数组，并比较大小，如果等于目标值，输出索引，如果小于目标值，往下遍历，如果大于目标值，跳出循环，
 * 输出索引值
 * 思路2：参考题解提供的二分法查找
 */
public class SearchInsert_35 {

    public static void main(String[] args) {
        int[] arrays = {1,3,5,6};
        System.out.println(new SearchInsert_35().searchInsert1(arrays, 8));
    }
    public int searchInsert(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]){
                return i;
            }
            if (target < nums[i]){
               continue;
            }else{
                count = i+1;
            }
        }
        return count;
    }

    public int searchInsert1(int[] nums, int target) {
       int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }
       int left= 0 ;
       int right = len -1;
       while (left <= right){
           int mid = (left + right )/2;
           if (target == nums[mid]){
               return mid;
           }else  if (nums[mid] < target){
               left = mid+1;
           }else{
               right = mid -1;
           }
       }
      /* if (target == nums[left]) {
           return left;
       }*/
        return left;
    }
}
