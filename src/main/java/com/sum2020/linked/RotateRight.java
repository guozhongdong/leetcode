package com.sum2020.linked;

/**
 * @author guozhongdong
 * @date 2020/11/3 19:51
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 每一步取最后一个非空节点，放在最前面，
 * 问题是如何取最后一个节点
 *
 * 闭环
 * 快慢指针
 *
 * k的长度很关键，可以大于链表长度n，也就是说最终移动的距离就是  k%n
 * 慢指针按 k%n 的距离走，
 * 解题关键1： 找好k的距离，k > n
 * 解题2 ： 找好首尾节点的位置，
 *
 */
public class RotateRight {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);


        new RotateRight().rotateRight(node,2);
        System.out.println();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode tmp = head;
        ListNode newHead = head;
        ListNode tail = head;

        //链表长度
        int count = 1;
        // tmp 肯定是最后一个节点，最终需要它连接首节点
        while (tmp.next != null){
            tmp = tmp.next;
            count+=1;
        }
        if (k == 0 || k % count == 0){
            return head;
        }
        int yi = k % count;
        //找到要断开的节点 中间部分不考虑，它的最后一个节点，肯定是原来的尾节点
        for (int i = 0; i < count-yi; i++) {
            tail = tail.next;
        }

        //找到要断开的节点上一个节点
        for (int i = 0; i < count-yi-1; i++) {
            newHead = newHead.next;
        }
        newHead.next = null;
        tmp.next = head;

        return tail;
    }
}
