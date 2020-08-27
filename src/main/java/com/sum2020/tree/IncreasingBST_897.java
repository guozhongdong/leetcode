package com.sum2020.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/8/27
 *
 * 897. 递增顺序查找树
 *
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *  
 *
 * 提示：
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 * 思路：先了解中序遍历的用法 LDR，这里使用递归
 * 组装新节点时，定义一个返回树的对象，在定义一个 接收新节点的对象，
 * 然后返回树的对象。
 *
 */
public class IncreasingBST_897 {

   private  List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        new IncreasingBST_897().increasingBST(root);
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        search(root,result);
        TreeNode node = null;
        TreeNode cur = null;
        if ( !result.isEmpty()){
            node = new TreeNode(result.get(0));
            // 重新定义一个节点，用于存放遍历的节点
            cur = node;
            for (int i = 1; i < result.size(); i++) {
                cur.right = new TreeNode(result.get(i));
                cur = cur.right;
            }
        }
        return node;
    }
    public void search(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        search(root.left,list);
        list.add(root.val);
        search(root.right,list);

    }

}
