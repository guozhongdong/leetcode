package com.sum2020.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gzd
 * @date 2020/1/4 下午2:10
 *
 * 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 思路：暴力解题法，并去重,嵌套循环
 * 关键字：排序，嵌套，去重
 *
 */
public class ForSum_18 {

    public static void main(String[] args) {

        int[] arrays = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> result = new ForSum_18().fourSum(arrays,target);
        System.out.println(result);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4){
            return result;
        }
        // 先排序，保证最小的在左边
        Arrays.sort(nums);
        // 开始嵌套遍历
        int a,b,c,d;
        int length = nums.length;
        // a是从最小开始遍历，
        for ( a = 0; a <= length-4 ; a++) {
            //确保nums[a]是变了的
            if (a>0 && nums[a] == nums[a-1]){
                continue;
            }
            int min = nums[a]+nums[a+1]+nums[a+2]+nums[a+3];
            if (min > target){
                break;
            }
            int max = nums[a]+nums[length-1]+nums[length-2]+nums[length-3];
            if (max < target){
                break;
            }
            for (b= a+1; b <= length-3; b++) {
                if (b>a+1 && nums[b] == nums[b-1]){
                    continue;
                }
                c = b+1;
                d = length-1;
                while (c<d){
                    if (nums[a]+nums[b]+nums[c]+nums[d] < target){
                        c++;
                    }else if (nums[a]+nums[b]+nums[c]+nums[d] > target){
                        d--;
                    }else {
                        result.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                        while (c<d && nums[c+1] == nums[c]){
                            c++;
                        }
                        while (c<d && nums[d-1] == nums[d]){
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }
        }


        return result;
    }
}
