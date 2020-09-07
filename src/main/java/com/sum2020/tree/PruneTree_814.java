package com.sum2020.tree;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/9/7
 * 814. 二叉树剪枝
 *  给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 *
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 *
 *
 *   示例2:
 *   输入: [1,0,1,0,0,0,1]
 *   输出: [1,null,1,null,1]
 *
 *
 *
 *  示例3:
 *  输入: [1,1,0,1,1,0,1,0]
 *  输出: [1,1,0,1,1,null,1]
 *
 * 思路：关于剪枝，删除二叉树的操作，都是采用后序遍历,首先根节点是 0 的就直接删除，
 * 后序遍历
 * LRD
 * 开始的错误理解，在剪完枝后，没有把剪枝后的值也就是null 赋给它的父节点对应的子节点，导致没有剪掉，
 * 假如我剪掉了左节点，则应该把左节点置位 空，并且告诉父节点，左节点为空，如果没有这部分赋值操作，只有剪枝操作，
 * 则只会遍历一遍树，没有对树的枝叶做出改变。
 *
 */
public class PruneTree_814 {

    public static void main(String[] args) {
        TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);


        TreeNode result = new PruneTree_814().pruneTree(root);
        System.out.println(root);
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null){
            return null;
        }
        //修改完节点，需告诉上一个节点
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && root.left == null && root.right == null){

            root = null;

        }

        return root;
    }
}
