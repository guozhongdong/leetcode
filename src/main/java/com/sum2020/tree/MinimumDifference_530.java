package com.sum2020.tree;

/**
 * @author gzd
 * @date 2020/4/23 下午8:43
 *530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 * 提示：
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * 思路：采用中序遍历，将根节点与左右两个节点分别比较，取绝对值
 *  * 设置一个全局变量存 最小绝对值
 * 错误思路：这题忘记了中序遍历的精髓，做成前序遍历了，
 *
 */
public class MinimumDifference_530 {
    int min = Integer.MAX_VALUE;
    // 记录根节点的值
    int num = 0;
    TreeNode pre = null;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(236);
        root.left = new TreeNode(104);
        root.right = new TreeNode(701);
        root.left.right = new TreeNode(227);
        root.right.right = new TreeNode(911);
        System.out.println(new MinimumDifference_530().getMinimumDifference(root));
    }
    public int getMinimumDifference(TreeNode root) {
        collec(root);
        return min;
    }


    public void collec(TreeNode root){

        /*if (root == null){
            return ;
        }
        if (root.left != null){
            min = Math.min(Math.abs(root.val - root.left.val),min);
            collec(root.left);
        }
        int num = root.val
        if (root.right != null){
            min = Math.min(Math.abs(root.val - root.right.val),min);
            collec(root.right);
        }*/
        if (root == null){
            return;
        }
        collec(root.left);
        if (pre != null){
            min = Math.min(min,Math.abs(root.val - pre.val));
        }
        pre = root;
        collec(root.right);

    }


}
