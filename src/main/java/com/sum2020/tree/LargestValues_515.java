package com.sum2020.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author guozhongdong
 * @date 2020/4/18 13:32
 *
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 * 思路：动态规划，dfs depth first search
 * 深度优先搜索
 *
 */
public class LargestValues_515 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        List<Integer> list = new LargestValues_515().largestValues(root);
        System.out.println(list);
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        // 设置一个队列，保存当前节点的相邻节点，第一次是保存根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            // 计算当前节点相邻的节点数量
            int size = queue.size();
            int min = Integer.MIN_VALUE;
            // 遍历相邻节点
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                min = Math.max(temp.val,min);
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
            }
            result.add(min);
        }
        return result;
    }

    public void dfs(TreeNode root,int depth){
        if (root == null){
            return;
        }



    }
}
