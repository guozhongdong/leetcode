package com.primary.dymatic;

/**
 * @author gzd
 * @create 2018-06-21 9:18
 * @desc:打家劫舍
 **/
public class DaJiaJieShe {

    public int rob(int[] nums) {
        if (nums == null && nums.length == 0 ){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            int result = nums[i];
        }
        return 0;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        new DaJiaJieShe().rob(nums);
    }
}
