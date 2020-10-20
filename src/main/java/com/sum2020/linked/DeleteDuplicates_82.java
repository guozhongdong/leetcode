package com.sum2020.linked;


/**
 * 82. 删除排序链表中的重复元素 II
 * @author guozhongdong
 * @date 2020/10/20 19:49
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 *
 * 链表的解法，要么递归，要么是额外增加指针，
 * 没有一次遍历能解决的
 *
 *
 */
public class DeleteDuplicates_82 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next.next = new ListNode(5);
        new DeleteDuplicates_82().deleteDuplicates(root);
    }


    /**
     * 双指针法，一个指针指向哑节点，一个指向哑节点的下一个节点
     * */
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        //哑节点
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode a = dumpy;
        ListNode b = head;

        //遍历，如果a节点不等于b节点，则都往后一步，如果相等， 则移动b节点，直到b不等于a
        while (b != null && b.next != null){
            if (a.next.val != b.next.val){
                a = a.next;
                b= b.next;
                //如果a 和b相等，则遍历b
            }else {
                while (b != null && b.next != null && a.next.val == b.next.val){
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }

        }


        return dumpy.next;
    }


    /**
     * 递归解法
     * 递归三部曲
     * 1、退出的条件是什么  当当前节点为空或者当前节点的下一个节点为空
     * 2、每一步做了什么，
     * 3、给上层返回什么
     * */
    public ListNode deleteDuplicates1(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        //如果当前节点的值等于下一个节点的值，就继续遍历下一个节点，直到找到一个不相等的节点
        if (head.val == head.next.val){
            while (head != null && head.next != null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates1(head.next);

        }else {
            // 递归找下一个没有重复的节点
            head.next = deleteDuplicates1(head.next);

            return head;
        }
    }
}
