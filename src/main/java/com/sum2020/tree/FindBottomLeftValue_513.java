package com.sum2020.tree;

/**
 * @author gzd
 * @date 2020/4/22 下午10:05
 * 513. 找树左下角的值
 *
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *  
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 *
 * 思路：主要是得记录深度，并且保证每一行最左边的值先遍历，则使用中序遍历
 * DLR
 * 通过深度来寻找最左值
 *
 */
public class FindBottomLeftValue_513 {
    int max = -1;
    int res = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        System.out.println(new FindBottomLeftValue_513().findBottomLeftValue(root));
    }

    public int findBottomLeftValue(TreeNode root) {
        collec(root,0);
        return res;
    }

    public void collec(TreeNode root,int dept){
        if (root == null){
            return;
        }
        if (dept > max){
            max = dept;
            res = root.val;
        }
        collec(root.left,dept+1);
        collec(root.right,dept+1);

    }
}
