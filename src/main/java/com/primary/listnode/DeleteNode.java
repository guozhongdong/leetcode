package com.primary.listnode;

/**
 * @author gzd
 * @create 2018-06-06 20:37
 * @desc
 **/
public class DeleteNode {
    public static void main(String[] args){

        //ListNode listNode = new ListNode(9);
        SingleList singleList = new SingleList();
        for (int i = 0; i < 5; i++) {
            singleList.add(i);
        }
        singleList.print(singleList.head);

    }
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }




}
