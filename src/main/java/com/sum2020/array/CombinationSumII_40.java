package com.sum2020.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 组合总和
 * @author guozhongdong
 * @date 2020/1/8 12:21
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * 1 1 2 5 6 7 10
 * 思路：参考leetcode上组合题解39， 采用递归 回溯 ，画图，剪枝 法，画图理解题意，
 * 参考39题解，只组合一次的话，就不用回溯了，
 * 不同点，不能使用相同的数字，则下一次递归应该是从 i+1开始的，如果当前是i 的话，i 的组合不能考虑自己，
 * 相同点：最终出现的组合不能有重复的，需要剪枝，剪枝的操作是 相同元素的话，跳过这个组合，进行下一个。
 *
 */
public class CombinationSumII_40 {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;


    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> list = new CombinationSumII_40().combinationSum(candidates,8);
        System.out.println(list);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0){
            return res;
        }
        // 排序
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.len = len;
        findCombinationSum(target,0,new Stack<>());
        return res;
    }
    /**
     * 递归方法
     * */
    private void findCombinationSum(int residue, int start, Stack<Integer> pre){
        if (residue < 0){
            return;
        }
        if (residue == 0){
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = start; i < len && residue-candidates[i] >= 0; i++) {
            //
            if(i > start && candidates[i-1] == candidates[i])
                continue;
            pre.add(candidates[i]);
            findCombinationSum(residue-candidates[i],i+1,pre);
            pre.pop();
        }

    }
}
