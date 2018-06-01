package com.primary.array;

/**
 * @author gzd
 * @create 2018-05-28 22:46
 * @desc   从排序数组中删除重复项
 **/
public class DeleteUnionsArray {

    public static void main(String[] args){
        int[] nums = {1,1,2,3,3};
        removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;
        int temp = 1;
        for (int i = 1; i <nums.length ; i++) {
            System.out.println("打印temp值："+temp);
            if (nums[i] != nums[i-1]){

                nums[temp] = nums[i];
                temp++;
            }
        }
        System.out.println("");
        for (int i = 0; i < nums.length ; i++) {
            System.out.println(nums[i]);
        }
        return temp;
    }

}
