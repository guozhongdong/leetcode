package com.sum2020.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guozhongdong
 * @date 2020/4/20 15:14
 * 508. 出现次数最多的子树元素和
 *
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。
 * 一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，
 * 返回所有出现次数最多的子树元素和（不限顺序）。
 *
 *
 * 示例 1：
 * 输入:
 *
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2：
 * 输入：
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 * 思路：递归遍历，取出每一个结点的子元素和，例如 5 是 5+2+-3 = 4
 * 2 是 2+0 + 0 = 2
 * -3 是 -3 +0 +0;
 * 递归每一个树，最终比较次数，
 * 主要是保存次数最多的，如何判断是出现次数最多的和如何保存呢？
 *
 * 用hashmap保存次数,并记录出现的最大值
 */
public class FindFrequentTreeSum_508 {

    private Map<Integer, Integer> map = new HashMap<>();
    //记录出现的最大次数
    int max = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.right = new TreeNode(-5);
        treeNode.left.right = new TreeNode(3);
        int[] nums = new FindFrequentTreeSum_508().findFrequentTreeSum(treeNode);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        // 用来保存出现的子集和
        calSum(root);
        for (Map.Entry<Integer, Integer> num : map.entrySet()) {
            if (num.getValue() == max) {
                list.add(num.getKey());
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int calSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int gen = node.val;
        int left = calSum(node.left);
        int right = calSum(node.right);
        int sum = gen + left + right;
        // map保存出现的次数
        if (map.containsKey(sum)) {
            map.put(sum, map.get(sum) + 1);
        } else {
            map.put(sum, 1);
        }
        max = Math.max(max, map.get(sum));
        return sum;
    }
}
