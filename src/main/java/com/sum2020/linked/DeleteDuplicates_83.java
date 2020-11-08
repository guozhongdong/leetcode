package com.sum2020.linked;

/**
 * @author gzd
 * @date 2020/11/8 下午4:08
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 *  复习递归三部曲
 *  1、最简单的终止条件是什么，终止值
 *  2、每一步返回的结果是什么，我需要什么样的结果，需要下个节点跟我不相等
 *  3、每一步做了哪些操作，返回一下一个节点
 *
 *
 */
public class DeleteDuplicates_83 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        /*root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(3);*/
       /* root.next.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next.next = new ListNode(5);*/
        ListNode node = new DeleteDuplicates_83().deleteDuplicates(root);
        System.out.println(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        //1、终止条件
        if (head == null || head.next == null){
            return head;
        }
        //2、返回下一个节点
        ListNode cur = head;
        ListNode next = deleteDuplicates(cur.next);
        if(next != null && cur.val == next.val){
            cur.next = next.next;
        }
        // 每一步就判断本节点跟下一个节点是否相等，如果相等则指向下一个节点的下个节点
        return cur;

    }

}
