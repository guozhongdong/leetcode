package com.sum2020.linked;

/**
 * @author guozhongdong
 * @date 2020/11/9
 *
 * 剑指 Offer 18. 删除链表的节点
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * 遍历主要是找出 给定节点的上一个节点和下下个节点
 *  
 */
public class DeleteNode {

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(5);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(9);

        new DeleteNode().deleteNode(root,9);

    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode newHead = head;
        if (newHead.val == val){
            newHead = newHead.next;
            return newHead;
        }
        while (newHead != null && newHead.next != null){
            if (newHead.next.val == val){
                newHead.next = newHead.next.next;
            }
            newHead = newHead.next;

        }
        return head;
    }
}
