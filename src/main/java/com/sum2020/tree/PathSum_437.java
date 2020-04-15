package com.sum2020.tree;

/**
 * @author gzd
 * @date 2020/4/15 下午8:24
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * 思路：双递归
 * 第一次是遍历 把
 *
 */
public class PathSum_437 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        System.out.println(new PathSum_437().pathSum(root, 8));
    }

    public int pathSum(TreeNode root, int sum) {

        if (root == null){
            return 0;
        }
        return subSum(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    /**
     * 子树和
     * */
    public int subSum(TreeNode root, int sum){
       if (root == null){
           return 0;
       }
       sum -= root.val;
       return (sum == 0?1:0) + subSum(root.left,sum) + subSum(root.right,sum);
    }
}
