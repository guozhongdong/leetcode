package com.sum2020.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * @author guozhongdong
 * @date 2020/12/9 19:37
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 * 主要是得找到 pos，咋找呢，啥意思题目，-_-,
 *
 * 1、给的就是环形的链表，开始理解错了，
 * 首先判断是不是环形的，快慢指针法，如果是环形的，快指针和慢指针一定会相遇，如果不是环形的，
 * 则快指针走完了，肯定不会相遇。
 *
 * 2、判断完是环形后，再去找环形的切入点，
 * 让一个新节点从头开始，让慢节点往下遍历，最终他们
 *
 * 头结点到入环节点A的长度为a , 到快慢指针相遇的节点B的长度为b
 *
 * 相当于头结点从开始走到他俩相遇一共走了 （a+b）的长度，
 *
 * 相遇后，如果慢指针继续走（a+b） 则还会到B,如果只走a的长度，则会走到入环节点，a咋来？
 * 但是a 的长度不知道，所以需要利用头结点从头开始走到入环节点，
 * 这样b肯定跟头结点都走到入环节点相遇，
 * =======================================================
 *
 * 再次说明：遇到链表的环形题，一定要优先考虑快慢指针的方法
 *
 */
public class DetectCycle_142 {



    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        ListNode result = new DetectCycle_142().detectCycle2(node);
        System.out.println();
    }
    public ListNode detectCycle(ListNode head) {

        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null){
                //快指针走两步
                fast = fast.next.next;
            }else{
                return null;
            }

            //相等了
            if (slow == fast){
                ListNode cur = head;
                while (cur != slow){
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }

        return null;

    }
    /**
     * 采用集合的方式
     * Set集合去重
     * */
    public ListNode detectCycle2(ListNode head) {
        if (head == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return head;
            }else{
                set.add(head);
                head = head.next;
            }
        }

        return null;

    }
}
