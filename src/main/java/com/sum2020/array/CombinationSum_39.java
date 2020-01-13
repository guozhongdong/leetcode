package com.sum2020.array;

import java.lang.annotation.Target;
import java.lang.reflect.Array;
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
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 思路：参考leetcode上题解， 采用递归 回溯 ，画图，剪枝 法，画图理解题意，
 *
 */
public class CombinationSum_39 {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;


    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        List<List<Integer>> list = new CombinationSum_39().combinationSum(candidates,7);
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
        findCombinationSum(target,0,new Stack<Integer>());
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
            pre.add(candidates[i]);
            findCombinationSum(residue-candidates[i],i,pre);
            pre.pop();
        }

    }
}
