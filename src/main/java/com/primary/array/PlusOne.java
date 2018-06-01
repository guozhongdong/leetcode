package com.primary.array;

/**
 * @author gzd
 * @create 2018-05-30 19:30
 * @desc
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 思路：从最低位开始 往前遍历，如果都是9 ,则把地位都置为0 ，并且则复制数组，最高位加1，如果有一位不是9 ，则最低位加1，
 **/
public class PlusOne {

    public static void main(String[] args){
        int[] nums = {8,9,9};
        int[] r = new PlusOne().plusOne(nums);
        for (int i = 0; i < r.length ; i++) {
            System.out.println(r[i]);
        }
    }
    public int[] plusOne(int[] digits) {

        int i = digits.length-1;
        while (i >= 0 && digits[i] == 9){
            digits[i] = 0;
            i--;
        }
        //System.out.println(i);
        // 说明都是连续的9，原数组长度不够了，
        if (i < 0 ){
            int[] res = new int[digits.length+1];
            System.arraycopy(digits,0,res,1,digits.length);
            res[0] = 1;
            return res;
        }else {
            digits[i] += 1;
            return digits;
        }

    }
}
