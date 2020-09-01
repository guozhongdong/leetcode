package com.sum2020.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/9/1
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *  思路，先了解层序遍历，也就是BFS 广度优先搜索
 *  分不了层
 *  加个 level 判断奇偶层
 *  双层循环，第一次遍历层，第二层循环遍历当前层的节点数，
 *  level 的作用是从左还是从右
 */
public class ZigzagLevelOrder_103 {

    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        new ZigzagLevelOrder_103().zigzagLevelOrder(root);

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        int oven = 0;
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue  = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            // 遍历每一层的节点
            for (int i = 0; i < size; i++) {
                TreeNode rut = queue.poll();

                if (rut.left != null){
                    queue.add(rut.left);
                }
                if (rut.right != null){
                    queue.add(rut.right);
                }
                if ((oven & 1) == 0){
                    list.add(rut.val);
                }else {
                    list.push(rut.val);
                }

            }
            result.add(list);
            oven++;

        }
        System.out.println(result);
        return result;
    }

    public void search(TreeNode root){


    }
}
