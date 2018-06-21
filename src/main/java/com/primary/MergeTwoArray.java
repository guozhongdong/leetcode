package com.primary;

/**
 * @author gzd
 * @create 2018-06-08 22:14
 * @desc
 **/
public class MergeTwoArray {

    public static void main(String[] args){
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != 0){
                m++;
            }
        }
        int n = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] != 0){
                n++;
            }
        }
        new MergeTwoArray().merge(nums1,m,nums2,n);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int j = 0; j < nums2.length; j++) {
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] == 0){
                    nums1[i] = nums2[j];
                    break;
                }
            }

        }
        for (int i = 0; i < nums1.length ; i++) {
            for (int j = i+1; j < nums1.length ; j++) {
                if (nums1[i] > nums1[j]){
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }

    }
}
