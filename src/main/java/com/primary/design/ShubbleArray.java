package com.primary.design;

import java.util.Random;

/**
 * @author gzd
 * @create 2018-06-23 9:12
 * @desc
 **/
public class ShubbleArray {

    public static void main(String[] args){
        int[] nums = {1,2,3};
        ShubbleArray obj = new ShubbleArray(nums);
        int[] param_1 = obj.reset();
        for (int i = 0; i < param_1.length; i++) {
            System.out.println(param_1[i]);
        }
        int[] param_2 = obj.shuffle();
        for (int i = 0; i < param_2.length; i++) {
            System.out.println(param_2[i]);
        }
    }
    public  int[] nums = null;
    public ShubbleArray(int[] nums){
            this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {

        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int [] arr2 =new int[this.nums.length];
        int count = this.nums.length;
        int cbRandCount = 0;// 索引
        int cbPosition = 0;// 位置
        int k =0;
        do {
           // runCount++;
            Random rand = new Random();
            int r = count - cbRandCount;
            cbPosition = rand.nextInt(r);
            arr2[k++] = this.nums[cbPosition];
            cbRandCount++;
            this.nums[cbPosition] = this.nums[r - 1];// 将最后一位数值赋值给已经被使用的cbPosition
        } while (cbRandCount < count);
        //System.out.println("m3运算次数  = "+runCount);
        return arr2;
    }
    /*public int[] removeElement(int ele,int [] arr){
        int [] arr2 =new int[arr.length-1];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            runCount++;
            if(arr[i]!=ele){
                arr2[k++] = arr[i];
            }
        }
        return arr2;
    }*/
}
