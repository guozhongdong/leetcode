package com.sum2020.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/9/2
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 * 思路：参考 二叉树的锯齿形层次遍历
 * 少了奇偶行的判断
 */
public class LevelOrder_32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        // 队列，存放每一层的节点数
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();
        queue.add(root);
        //遍历层
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> jieguo = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                jieguo.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }

            }
            results.add(jieguo);
        }
        System.out.println(results);
        return results;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        new LevelOrder_32().levelOrder(root);
    }
}
