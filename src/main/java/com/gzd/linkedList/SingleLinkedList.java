package com.gzd.linkedList;

/**
 * @author gzd
 * @create 2018-06-17 10:06
 * @desc:实现单向链表
 * 初学：使用递归实现
 **/
public class SingleLinkedList {

    private Node head = null; // 定义一个根节点


    public void addKey(int data){
        if (head == null){   // 如果head等于null，说明是根节点
            head = new Node(data);
        }else{
            head.add(data);
        }


    }
    public void delNode(int data){
        if (head.data == data){
            head = head.next;
        }else{
            head.del(data);
        }

    }

    public void printNode(){
        if (head != null ){
            System.out.print(head.data);
            head.print();
            System.out.println("");
        }
    }
    /**
     * 返回节点长度
     * */
    public int length(){
        if (head == null){
            return 0;
        }
        int length = 0;
        while (head != null ){
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addKey(6);
        singleLinkedList.addKey(2);
        singleLinkedList.addKey(3);
        singleLinkedList.addKey(4);
        singleLinkedList.addKey(5);
        singleLinkedList.printNode();
        singleLinkedList.delNode(3);

        singleLinkedList.printNode();
        int num = singleLinkedList.length();
        System.out.println(num);
    }

}
