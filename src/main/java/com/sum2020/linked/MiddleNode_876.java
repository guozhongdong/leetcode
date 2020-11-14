package com.sum2020.linked;

/**
 * @author guozhongdong
 * @date 2020/11/14 14:15
 *
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 * 思路：先遍历链表的长度，得到中间节点，再接着遍历 到中间节点，返回后续节点
 *
 * 一、数组下标法
 *
 * 二、两次链表遍历
 *
 * 三、快慢指针
 *
 */
public class MiddleNode_876 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        ListNode result = new MiddleNode_876().middleNode3(node);
        System.out.println();
    }

    public ListNode middleNode(ListNode head) {
        if (head == null|| head.next == null){
            return head;
        }
        ListNode root = head;
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        int mid = len/2+1;
        for (int i = 1; i < mid; i++) {
            root = root.next;
        }

        return root;
    }
    // 数组下标法
    public ListNode middleNode2(ListNode head) {
        if (head == null|| head.next == null){
            return head;
        }

        ListNode[] nodes = new ListNode[100];
        int len = 0;
        while (head != null){
            nodes[len++] = head;
            head = head.next;
        }
        return nodes[len/2];
    }
    /*
     *
     *快慢指针法
     * 快指针是慢
     */
    public ListNode middleNode3(ListNode head) {
        if (head == null|| head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
