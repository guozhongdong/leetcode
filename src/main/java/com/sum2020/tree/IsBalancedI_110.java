package com.sum2020.tree;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/9/9
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *  思路：先做的是平衡二叉树II,判断一颗树是不是平衡二叉树
 *  还是从上到底遍历，判断每一个节点的左右子树 的高度差是否大于1
 *  递归
 *  树的高度 = 左子树或右子树深度的最大值 + 1;
 *  链表
 */
public class IsBalancedI_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //计算每个节点子树的高度
    public int getDepth(TreeNode node){
        //如果结点为null，则高度就为0
        if (node == null){
            return 0;
        }

        return Math.max(getDepth(node.left),getDepth(node.right))+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(new IsBalancedI_110().isBalanced(root));
    }
}
