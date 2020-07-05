package com.sum2020.tree;

/**
 * @author gzd
 * @date 2020/7/5 上午10:28
 *
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 * 思路：递归求每个子树的最大序列和
 *    a
 *
 *  b   c
 *
 * a+b+c
 * b+a+a的父节点
 * c+a+a父节点
 *
 * 对于a这个结点来说，就这三种可能求最大值，然后跟其他节点的进行比较，
 *
 *
 */
public class MaxPathSum_124 {
    public int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new MaxPathSum_124().maxPathSum(root));
    }


    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        getMax(root);
        return max;
    }

    public int getMax(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = Math.max(0,getMax(root.left));
        int right = Math.max(0,getMax(root.right));
        // 记录一个最大值，结点的最大路径和等于 该节点的值+ 该节点左右节点的最大贡献值
        max = Math.max(max,root.val+left+right);
        // 返回一个单边最大的和 类似 b+a或者c+a
        return root.val + Math.max(left,right);
    }
}
