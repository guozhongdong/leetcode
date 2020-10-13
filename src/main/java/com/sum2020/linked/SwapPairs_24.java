package com.sum2020.linked;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/9/28
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 思路：一次遍历两个结点，然后交换值和交换节点的后续节点
 *
 * 递归，先递归的交换位置，等把两两的位置都交换完了，之后再从后到前把指针都指上。
 *
 */
public class SwapPairs_24 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        new SwapPairs_24().swapPairs(node);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        // 设置一个新的头结点
        ListNode newHead = head.next;
        // 老的头节点应该指向下一个 应该两两交换的节点，下一个应该继续递归交换位置
        //newHead.next 就是后面的节点
        head.next = swapPairs(newHead.next);
        // 交换过后，把指针关系指正
        newHead.next = head;


        return newHead;
    }
}
