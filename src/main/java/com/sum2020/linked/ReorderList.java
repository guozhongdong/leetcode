package com.sum2020.linked;

/**
 * @author guozhongdong
 * @date 2020/10/15 19:48
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 思路：从头和从后面遍历链表，把最后的链表 穿插在第一个节点和第二个节点之间
 * 找尾节点比较耗时
 * 参考题解
 * 快慢指针 找到中点，然后把中点往后的节点倒叙，再分别连接插入
 *
 * 1、快指针一次走两步，慢指针一次走一步，快指针走到头，慢指针刚好走到中点，
 * 2则把它之后的节点取出来 ，翻转，
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        new ReorderList().reorderList(node);
        System.out.println();
    }

    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null){
            return;
        }
        //声量两个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 取出中点之后的节点
        ListNode newHead = slow.next;
        // slow就是中点的前半部分
        slow.next = null;
        newHead = reorder(newHead);

        //开组装链表
        while (newHead != null){
            //保存后面节点的
            ListNode cur = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = cur;

        }

    }

    /**
     * 翻转单链表
     * */
    public ListNode reorder(ListNode head){
        if (head == null){
            return null;

        }
        ListNode tail = head;
        head = head.next;
        tail.next = null;
        while (head != null){
            ListNode cur = head.next;
            head.next = tail;
            tail = head;
            head = cur;
        }
        return tail;

    }
}
