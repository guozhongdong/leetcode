package com.sum2020.tree;

/**
 * @author gzd
 * @date 2020/4/12 下午1:41
 *
 * 404.左叶子指和
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 思路：遍历树，并记录它的左子树
 * 遍历的树的方式很多，我们采用前序遍历
 * 递归
 *
 * 没有想到要加一个 左节点的标识，导致一直没有找到最佳 出递归点,
 * 这个标识为很重要，导致一直没有get到输出点，消耗了不少时间
 *
 */
public class SumOfLeftLeaves_404 {


    private int sum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new SumOfLeftLeaves_404().sumOfLeftLeaves(root));

    }
    public int sumOfLeftLeaves(TreeNode root) {

        getSum(root,false);

        return sum;
    }

    public void getSum(TreeNode root,boolean flag){
        if (root != null){
            if (flag && root.left == null && root.right == null){
                sum += root.val;
            }else {
                getSum(root.left,true);
                getSum(root.right,false);
            }
        }
    }


}
