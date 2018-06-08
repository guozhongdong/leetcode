package com.primary.listnode;

/**
 * @author gzd
 * @create 2018-06-06 21:29
 * @desc 删除链表的倒数第N个节点
 **/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode perNode = head;
        ListNode curNode = head;
        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }
        if (curNode == null){
            return  perNode.next;
        }
        while (curNode.next != null){
            perNode = perNode.next;
            curNode = curNode.next;
        }
        perNode.next = perNode.next.next;
        return head;
    }
    public static void main(String[] args){

    }
}
