package com.primary;

/**
 * @author gzd
 * @create 2018-05-31 9:38
 * @desc 移动零
 * 思路1：先将非0 的数压缩一下，然后后面的直接补0
 * 思路2:建立两个索引，从后往前遍历，指导找到一个为0的数，把后面的值都往前移一位，相应的最后位置0
 **/
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        //思路1
        /*int poss = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != 0) {
                nums[poss] = nums[i];
                poss++;
            }
        }
        System.out.println(poss+"=========");
        // 后面的位数补0
        for (int i = poss; i < nums.length ; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println();*/
        // 思路2
        int currIndex = nums.length -1;
        int lastIndex = nums.length -1;
        int count = 0;
        while (currIndex >= 0){
            if (nums[currIndex] == 0){
                count = lastIndex - currIndex;
                for (int i = 0; i < count; i++) {
                    nums[currIndex+i] = nums[currIndex+i+1];
                }
                nums[lastIndex] = 0;
                lastIndex--;
            }
            currIndex--;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }



}
