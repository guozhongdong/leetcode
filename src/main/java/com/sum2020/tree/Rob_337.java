package com.sum2020.tree;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.RepositoryIdHelper;

/**
 * @author gzd
 * @date 2020/4/13 下午7:50
 * 树
 * 打家劫舍_337
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，
 * 每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 思路：直接相连的两个房子，不能同时打劫，从根节点开始，跳节点获取元素，隔一个获取一个最大的，每个房子只有一个父节点
 * 每次判断左右节点的大小，
 * 遍历根左右，找一个最大的节点出来，下次循环不带根，左右找出一个最大的节点来，
 * 前序遍历,暴力递归
 *
 */
public class Rob_337 {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        /*treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(1);
        treeNode.right.right = new TreeNode(1);*/
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(1);

        System.out.println(new Rob_337().rob(treeNode));
    }

    public int rob(TreeNode root) {

        if (root == null){
            return 0;
        }
        // 计算爷爷加两个孙子的钱
        int num = root.val;
        if (root.left != null){
            num += (rob(root.left.left)+rob(root.left.right));
        }
        if (root.right != null){
            num += (rob(root.right.left)+rob(root.right.right));
        }
        // 计算两个儿子的钱，跟爷爷加孙子相比，取一个最大值
        return Math.max(num,(rob(root.left)+rob(root.right)));
    }
    /**
     * 优秀解法
     * 计算一个节点 偷和不偷各自能获得最大的收益，最后比较这两种方式的最大值
     * 当前节点不偷 value = 左节点偷的最大值 + 右节点的最大值
     * 当前节点偷 value = 当前节点的值+ 左节点不偷的最大值 + 右节点不偷的最大值
     *
     * 我们使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
     * root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
     * root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
     *
     * */

    public int rob2(TreeNode root){
        int[] result = getMaxNode(root);
        return Math.max(result[0], result[1]);
    }
    public int[] getMaxNode(TreeNode root){

        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = getMaxNode(root.left);
        int[] right = getMaxNode(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;

    }
}
