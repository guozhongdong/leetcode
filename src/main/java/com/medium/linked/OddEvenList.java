package com.medium.linked;

/**
 * @author gzd
 * @create 2018-07-19 21:13
 * @desc  奇偶链表
 *  使用原地算法，空间复杂度为O(1),时间复杂度为 O(nodes)
 **/
public class OddEvenList {

    public static void main(String[] args){

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null ){
            return  null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode prevOdd = odd;
        ListNode prevEven = even;
        while (prevOdd.next != null && prevEven.next != null ){
            // 奇数位往前赋值
            prevOdd.next = prevEven.next;
            prevOdd = prevOdd.next;

            prevEven.next = prevOdd.next;
            prevEven = prevEven.next;
        }
        prevOdd.next = even;
        // 1,2,4,5,6,7,9
        // 1 4 6 9 2 5 7

        return odd;
    }
}
