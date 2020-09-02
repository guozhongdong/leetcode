package com.sum2020.tree;

import java.util.LinkedList;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/9/2
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 广度优先搜索
 * 遍历节点，计算节点的和，
 *
 * 递归
 *
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        //一个队列保存节点，一个队列保存根路径到这个节点的和，
        LinkedList<TreeNode> queueNode = new LinkedList<>();
        LinkedList<Integer> queueVal = new LinkedList<>();
        queueNode.add(root);
        queueVal.add(root.val);

        while (!queueNode.isEmpty()){

            TreeNode node = queueNode.poll();
            int target = queueVal.poll();
            //到其中一个跟节点了，如果计算的目标值和给定的和相等，则返回出去。否则继续遍历
            if (node.left == null && node.right == null){
                if (target == sum){
                    return true;
                }
                continue;
            }
            if (node.left != null){
                queueNode.add(node.left);
                queueVal.add(target + node.left.val);
            }
            if (node.right != null){
                queueNode.add(node.right);
                queueVal.add(target + node.right.val);
            }
        }
        return false;
    }

    /**
     * 递归方式，通过给点和，反推，已知是从根节点到 叶子结点，也就说存在 根节点的值+叶子节点的值，
     * 递归遍历节点的值，这下一个满足条件就是 sum - root.val ;
     * 递归下去
     * */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        //如果当前是叶子结点，判断是否等于 sum 剩下来的值
        if (root.left == null && root.right == null){
            return sum == root.val;
        }

        return hasPathSum1(root.left,sum - root.val) || hasPathSum1(root.right,sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(new HasPathSum().hasPathSum(root, 22));
        System.out.println(new HasPathSum().hasPathSum1(root, 22));
    }
}
