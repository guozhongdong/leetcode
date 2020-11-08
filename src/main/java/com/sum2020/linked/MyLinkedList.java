package com.sum2020.linked;

/**
 * @author gzd
 * @date 2020/11/8 下午7:27
 *
 * 设计一个单链表支持如下功能
 *
 */
public class MyLinkedList {

    /** Initialize your data structure here. */


    //链表头节点
    private ListNode head;
    //链表长度
    private int size;

    public MyLinkedList() {
        this.size = 0;
        head = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i < index+1; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        addAtIndex(size, val);

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // If index is greater than the length,
        // the node will not be inserted.
        if (index > size)
            return;

        // [so weird] If index is negative,
        // the node will be inserted at the head of the list.
        if (index < 0)
            index = 0;
        ++size;
        // find predecessor of the node to be added
        ListNode pred = head;
        for(int i = 0; i < index; ++i)
            pred = pred.next;

        // node to be added
        ListNode toAdd = new ListNode(val);
        // insertion itself
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    /** Delete the index-th node in the linked list, if the index is valid.
     *
     * 1 2 3 4 6
     *
     *
     * */
    public void deleteAtIndex(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size) return;

        size--;
        // find predecessor of the node to be deleted
        ListNode pred = head;
        for(int i = 0; i < index; ++i)
            pred = pred.next;

        // delete pred.next
        pred.next = pred.next.next;

    }


    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3


    }

}
