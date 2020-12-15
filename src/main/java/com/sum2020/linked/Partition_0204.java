package com.sum2020.linked;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @author guozhongdong
 * @date 2020/12/15 19:53
 *
 * 面试题 02.04. 分割链表
 *
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
 * 分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 *
 *
 * 思路：也就是说给定的值不一定非要放在中间
 * 用一个双端队列
 *
 */
public class Partition_0204 {
    Deque<Integer> queue = new LinkedList<>();

    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode node = head;
        while (node != null){
            if (node.val < x){
                queue.addFirst(node.val);
            }else{
                queue.addLast(node.val);
            }
            node = node.next;

        }
        ListNode result = new ListNode(-1);
        ListNode mn = result;
        while (!queue.isEmpty()){
            ListNode ans = new ListNode(queue.pop());
            mn.next = ans;
            mn = mn.next;
        }
        System.out.println();
        return result.next;
    }
    /**
     * 不借用第三方内存
     * 想到了用双指针法，一个指针存小值，一个指针存大值，
     * 但是在拼接的时候，没拼住，
     * 忘记了java对象堆内存的联系，多个引用可以指向同一个堆对象
     * */
    public ListNode partition2(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode big = new ListNode(-1);
        ListNode biR = big;
        ListNode small = new ListNode(-1);
        ListNode smallR = small;
        ListNode cur = head;
        while (cur != null){
            if (cur.val < x){
                ListNode ans = new ListNode(cur.val);
                small.next = ans;
                small = ans;
            }else{
                ListNode ans = new ListNode(cur.val);
                big.next = ans;
                big = ans;
            }
            cur = cur.next;
        }
        small.next = biR.next;
        return  smallR.next;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(5);
        node.next.next = new ListNode(8);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(10);
        node.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next = new ListNode(1);

        ListNode no = new Partition_0204().partition2(node,5);
        System.out.println();
    }
}
