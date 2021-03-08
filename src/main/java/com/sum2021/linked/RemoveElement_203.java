package com.sum2021.linked;



/**
 * @author guozhongdong
 * @date 2021/3/8 20:26
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 列表中的节点在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 *
 * 思路：遍历head,并且组装新的newNode节点
 *
 *
 */
public class RemoveElement_203 {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        new RemoveElement_203().removeElements(node,6);

    }
    // 设置虚拟节点
    public ListNode removeElements(ListNode head, int val) {

        if (head == null){
            return null;
        }
        //新的链表
        ListNode newHead = new ListNode(-1);
        ListNode root = newHead;
        while (head != null){
            if (head.val != val){
                root.next = new ListNode(head.val);
                root = root.next;
            }
            head = head.next;
        }

        return newHead.next;
    }


    /**
     * 方法2 ，递归解法,不设置虚拟节点
     * 每一次都是看下一个节点，是否等于目标节点，等于的话，直接跳过，不等于的话，正常遍历
     * 每一次递归，都是去掉目标节点
     * */
    public ListNode removeElements2(ListNode head, int val) {

        if (head == null){
            return null;
        }
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }


}
