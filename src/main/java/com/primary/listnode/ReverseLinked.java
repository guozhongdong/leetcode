package com.primary.listnode;

/**
 * @author gzd
 * @create 2018-06-07 13:39
 * @desc
 **/
public class ReverseLinked {

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null ){

            pre.next = cur.next;
            cur.next = head;
            head = cur;
            cur= pre.next;
        }
        return head;
    }
}
