package com.primary.dymatic;

/**
 * @author gzd
 * @create 2018-06-22 12:37
 * @desc:
 **/
public class MaxSubArray {

    public static void main(String[] args){
        int[] nums ={-2,1,-3,4,-1,2,1,-5,4};
        int n = new MaxSubArray().maxSubArray(nums);
        System.out.println(n);
    }
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > maxSum){
                maxSum = sum;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
}
