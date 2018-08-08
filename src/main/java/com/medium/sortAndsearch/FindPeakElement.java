package com.medium.sortAndsearch;

/**
 * @author gzd
 * @create 2018-08-08 13:32
 * @desc 寻找峰值 ,并返回其索引值
 * nums[-1] = nums[n] = -∞。
 **/
public class FindPeakElement {

    public static void main(String[] args){
        int[] nums = {1,2,1,3,5,6,4};
        int n = new FindPeakElement().findPeakElement(nums);
        System.out.println(n);
    }

    public int findPeakElement(int[] nums) {
        // 普通方法
        /*if (nums.length == 1){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                if (nums[i] > nums[i+1]){
                    return i;
                }
            }else if(i == nums.length-1){
                if (nums[i] > nums[i-1]){
                    return i;
                }
            }else{
                if (nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                    return i;
                }
            }

        }*/
        // ==========================================================
        //使用二分法使时间复杂度为nlogn
        int i = 0;
        int j = nums.length-1;
        while (i < j){
            int temp = (i+j)/2;
            if (nums[temp] > nums[temp+1]){
                j = temp;
            }else {
                i = temp+1;
            }

        }

        return i;
    }
}
