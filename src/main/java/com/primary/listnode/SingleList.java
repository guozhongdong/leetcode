package com.primary.listnode;

/**
 * @author gzd
 * @create 2018-06-06 21:04
 * @desc:创建一个单链表
 **/
public class SingleList {
    ListNode head;
    ListNode current;

    public void add(int data) {
        //判断链表为空的时候
        if (head == null) {//如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
            head = new ListNode(data);
            current = head;
        } else {
            //创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
            current.next = new ListNode(data);
            //把链表的当前索引向后移动一位
            current = current.next; //此步操作完成之后，current结点指向新添加的那个结点
        }
    }

    //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
    public void print(ListNode node) {
        if (node == null) {
            return;
        }
        current = node;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
