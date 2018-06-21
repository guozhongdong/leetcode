package com.primary.dymatic;

/**
 * @author gzd
 * @create 2018-06-21 9:18
 * @desc:打家劫舍
 * 思路：先判断当前物资跟上一个屋子 里面哪个钱多，然后采用递推式
 **/
public class DaJiaJieShe {

    public int rob(int[] nums) {
        /*if (nums == null && nums.length == 0 ){
            return 0;
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            int result = 0;

            for (int j = i; j < nums.length; j+=2) {
                result += nums[j];
            }
            System.out.println(result);
            temp = Math.max(result,temp);
        }
        return temp;*/
        /*int curMax = 0, curPrePreMax = 0;
        for (int cur : nums) {
            int temp = curMax;
            curMax = Math.max(curMax, curPrePreMax + cur);
            curPrePreMax = temp;
        }
        return curMax;*/


        if(nums.length <= 1){
            return nums.length == 0 ? 0 : nums[0];
        }
        // a是上次的最大收益
        int a = nums[0];
        // b是当前的最大受益
        int b = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            int tmp = b;
            // 当前的最大收益是两种选择里较大的那个
            b = Math.max(a + nums[i], b);
            a = tmp;
        }
        return b;

    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        int n = new DaJiaJieShe().rob(nums);
        System.out.println(n);
    }
}
