package com.primary.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzd
 * @create 2018-06-19 9:10
 * @desc:缺失数字 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数
 **/
public class MissingNumber {

    public static void main(String[] args){
        int[] nums = {3,0,1};
        int k = new MissingNumber().missingNumber(nums);
        System.out.println(k);
    }
    /*使用额外的空间实现*/
    public int missingNumber(int[] nums) {
        HashMap<Integer,Boolean> hashMap = new HashMap<>();

        for (int i = 0; i <= nums.length ; i++) {
            hashMap.put(i,true);
        }
        for (int i = 0; i < nums.length ; i++) {
            hashMap.put(nums[i],false);
        }
        for (Map.Entry<Integer, Boolean> j : hashMap.entrySet()){
            if (j.getValue()){
               return j.getKey();
            }
        }

        return -1;
    }
}
