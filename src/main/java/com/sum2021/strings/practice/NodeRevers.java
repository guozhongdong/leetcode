package com.sum2021.strings.practice;

import com.gzd.linkedList.Node;

/**
 * @author guozhongdong
 * @date 2021/1/14 19:46
 *
 * 练习题
 *1、链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，
 * 则翻转后2→1→6→5→4→3，若k=3，翻转后3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现。
 */
public class NodeRevers {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(6);

        new NodeRevers().ReversToNode(root,4);
    }

    public Node ReversToNode(Node node,int k){
        if (node == null){
            return null;
        }
        Node cur = node;
        Node pre = new Node(-1);
        Node last = new Node(-1);

        Node preNew  = pre;
        Node lastNew  = last;

        int num = 0;
        while (cur != null){
            if (num < k){
                pre.next = new Node(cur.data);
                pre = pre.next;
            }else{
                last.next = new Node(cur.data);
                last = last.next;
            }
            num++;
            cur = cur.next;
        }
        System.out.println(preNew);
        Node reversPre = revers(preNew.next);
        Node reversLast = revers(lastNew.next);
        Node result = reversPre;
        while (result.next != null){
            result = result.next;
        }
        result.next = reversLast;
        return reversPre;
    }

    /**
     * 翻转单个链表
     * */
    public Node revers(Node node){
        Node cur = node;
        Node newHead = null;
        while (cur != null){
            Node second = new Node(cur.data);
            second.next = newHead;
            newHead = second;
            cur = cur.next;
        }
        System.out.println(newHead);
        return newHead;
    }
}
