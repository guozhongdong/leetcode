package com.medium.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzd
 * @create 2018-09-17 21:32
 * @desc 求众数
 * 众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 **/
public class MajorityElement {

    public static void main(String[] args){
        int[] nums = {2,2,1,1,1,2,2};
        int n = majorityElement(nums);
        System.out.println(n);
    }
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        int n = len/2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for (Map.Entry entry:map.entrySet()){
            if ((int)entry.getValue() > n){
                return (int)entry.getKey();
            }
        }
        return 0;
    }
}
