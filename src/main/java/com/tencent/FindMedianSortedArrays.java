package com.tencent;

/**
 * @author gzd
 * @date create in 2019/1/23 20:49
 * 寻找两个有序数组的中位数
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 * 思路：两个数组按大小整合成一个数组，在算中位数------此思路算法复杂度不符合
 *
 **/
public class FindMedianSortedArrays {

    public static void main(String[] args){
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        double b = new FindMedianSortedArrays().findMedianSortedArrays(nums1,nums2);
        System.out.println(b);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];
        int i=0,j=0,k = 0;
        while (i < m && j <n){
            if (nums1[i] < nums2[j]){
                nums[k++] = nums1[i++];
            }else{
                nums[k++] = nums2[j++];
            }
        }
        while (i == nums1.length && j < nums2.length){
            nums[k++] = nums2[j++];
        }

        while (i < nums1.length && j == nums2.length){
            nums[k++] = nums1[i++];
        }


        double zhong = 0.0;
        if ( (nums.length % 2) == 0){
           zhong = (nums[nums.length/2] + nums[nums.length/2-1])/2.0;
        }else{
            zhong = nums[nums.length/2];
        }

        return zhong;
    }
}
