package com.byteDance.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gzd
 * @create 2018-12-13 22:02
 * @desc 最长连续序列
 * 描述：给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 思路：先排序，然后判断大小，但是时间复杂度不满足
 * 网上查看资料：利用空间换时间，遍历一遍，将数存到map中，并且把左边的和右边的都存进去 map中，
 * 之后遍历数字的时候，先查map中是否存在这个数字，如果是 取出它对应的value值，
 **/
public class LongestConsecutive {

    public static void main(String[] args){
        int[] nums = {100, 4, 200, 1, 3, 2};
        int n = new LongestConsecutive().longestConsecutive(nums);
        System.out.println(n);
    }

    public int longestConsecutive(int[] nums) {

        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                continue;
            }
            int left = map.containsKey(nums[i]-1)?map.get(nums[i]-1):0;
            int right = map.containsKey(nums[i]+1)?map.get(nums[i]+1):0;
            int sum = left+right+1;
            map.put(nums[i],sum);
            res = Math.max(res,sum);
            map.put(nums[i]-left,sum);
            map.put(nums[i]+right,sum);
        }
         return res;
    }
}
