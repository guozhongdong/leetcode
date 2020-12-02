package com.sum2020.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozhongdong
 * @date 2020/12/2 19:55
 *
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 *
 * 简单的实现方法方法 一个列表存值，一个计数，按下标取数即可
 *
 * 在一个 双指针，这个很妙
 * 第一个指针先移动k步，然后两个指针一起走，当第一个指针到达末尾时，则直接返回第二个指针的值。
 *
 * 三、递归，类似于从尾遍历链表
 *
 *
 *
 * 这个很好，简单，容易给人自信，而且便于扩展思路
 */
public class KthToLast_0202 {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        //int num = new KthToLast_0202().kthToLast1(node,2);
        int num1 =  new KthToLast_0202().kthToLast2(node,2);
        //System.out.println(num);
        System.out.println(num1);
    }
    /**
     * 最简答的方法
     * */
    public int kthToLast(ListNode head, int k) {

        List<Integer> list = new ArrayList<>();
        int count = 0;
        while(head != null){
            count++;
            list.add(head.val);
            head = head.next;
        }
        return list.get(count-k);

    }
    /**
     *
     * 双指针法
     * */
    public int kthToLast1(ListNode head, int k) {

        ListNode first = head;
        ListNode second = head;
        while (k > 0){
            first = first.next;
            k--;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }

        return second.val;

    }
    /**
     *
     * 递归方法
     * 增加一个外部变量size ，记录尾部遍历的个数，
     * 为空时推出
     * 每一步返回当前节点的 值，
     *
     * */
    int size ;
    public int kthToLast2(ListNode head, int k) {

        if (head == null){
            return 0;
        }
        int value = kthToLast2(head.next,k);
        size++;
        if (k == size){
            return head.val;
        }

        return value;
    }




}
