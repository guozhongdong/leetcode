package com.sum2020.tree;

import com.medium.linked.ListNode;

/**
 * @author gzd
 * @date 2020/7/2 下午9:01
 *
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 *
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 *
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * 解释：树中蓝色的节点构成了与链表对应的子路径。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：true
 * 示例 3：
 *
 * 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
 * 输出：false
 * 解释：二叉树中不存在一一对应链表的路径。
 *  
 *
 * 提示：
 *
 * 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
 * 链表包含的节点数目在 1 到 100 之间。
 * 二叉树包含的节点数目在 1 到 2500 之间。
 *
 * 原理同 检查子树
 * 递归法 遍历节点
 */
public class sSubPath_1367 {

    public static void main(String[] args) {

    }
    public boolean isSubPath(ListNode head, TreeNode root) {

        if (root == null){
            return false;
        }
        if (head == null){
            return true;
        }

        return isSub(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }

    /**
     * 检查结点 结果是不是一样
     * */
    public boolean isSub(ListNode head,TreeNode root){
        //有一处错误，应该先判断链表
        if (head == null){
            return true;
        }
        if (root == null){
            return false;
        }

        if (head.val != root.val){
            return false;
        }
        return isSub(head.next,root.left) || isSub(head.next,root.right);
    }

}
